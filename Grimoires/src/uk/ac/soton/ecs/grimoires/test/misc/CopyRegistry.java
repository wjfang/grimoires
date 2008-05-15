package uk.ac.soton.ecs.grimoires.test.misc;

import java.rmi.RemoteException;

import org.apache.log4j.Logger;

import uk.ac.soton.ecs.grimoires.proxy.GrimoiresProxy;
import uk.ac.soton.ecs.grimoires.proxy.MissingInformationException;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.proxy.ws.GrimoiresjUDDIWebServiceProxyFactory;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessEntity;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.BusinessList;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.DispositionReport;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_business;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.Save_tModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModel;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelDetail;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelInfo;
import uk.ac.soton.ecs.grimoires.server.impl.uddiv2.datamodel.TModelList;

public class CopyRegistry {
	final private static Logger logger = Logger.getLogger(CopyRegistry.class);
	
	private GrimoiresProxy source;
	private GrimoiresProxy target;
	
	public CopyRegistry(GrimoiresProxy source, GrimoiresProxy target){
		this.source = source;
		this.target = target;
	}
	
	public void copy() {
		copyTModels();
		copyBusinesses();
	}

	private void copyTModels() {
		TModelList tmodelList = null;
		try {
			tmodelList = source.findTModel("%");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return;
		}
		if (tmodelList == null || tmodelList.getTModelInfos() == null
				|| tmodelList.getTModelInfos().getTModelInfo() == null
				|| tmodelList.getTModelInfos().getTModelInfo().length == 0) {
			logger.info("No tmodel found in the source registry.");
			return;
		}
		
		TModelInfo[] infos = tmodelList.getTModelInfos().getTModelInfo();
		for (TModelInfo info : infos) {
			if (info == null) continue;			
			String name = info.getName().get_value();
			
			logger.info("Retrieve tmodel " + name   
					+ " from the source registry.");
			TModelDetail detail = null;
			try {
				detail = source.getTModelDetail(info.getTModelKey());
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			if (detail == null || detail.getTModel() == null
					|| detail.getTModel()[0] == null) {
				logger.error("Fail to get tmodel " + name 
						+ " from the source registry.");
				continue;
			}
			TModel tmodel = detail.getTModel()[0];
			
			logger.info("Publish tmodel " + name 
					+ " into the target registry.");
			Save_tModel request = new Save_tModel();
			request.setTModel(new TModel[]{tmodel});
			try {
				target.saveTModel(request);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			/*
			 * Verification
			 */
			try {
				detail = target.getTModelDetail(info.getTModelKey());
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			if (detail == null || detail.getTModel() == null
					|| detail.getTModel()[0] == null) {
				logger.error("Fail to get tmodel " + name 
						+ " from the target registry.");
				continue;
			}
			TModel tmodel2 = detail.getTModel()[0];
			if (!tmodel.equals(tmodel2)) {
				logger.error("Different tmodel " + name 
						+ " between source and target.");
			}
		}
	}

	private void copyBusinesses() {
		BusinessList businessList = null;
		try {
			businessList = source.findBusiness("%");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return;
		}
		if (businessList == null || businessList.getBusinessInfos() == null
				|| businessList.getBusinessInfos().getBusinessInfo() == null
				|| businessList.getBusinessInfos().getBusinessInfo().length == 0) {
			logger.info("No business found in the source registry.");
			return;
		}
		
		BusinessInfo[] infos = businessList.getBusinessInfos().getBusinessInfo();
		for (BusinessInfo info : infos) {
			if (info == null) continue;
			String name = info.getName(0).get_value();
			
			logger.info("Retrieve business " + name   
					+ " from the source registry.");
			BusinessDetail detail = null;
			try {
				detail = source.getBusinessDetail(info.getBusinessKey());
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			if (detail == null || detail.getBusinessEntity() == null
					|| detail.getBusinessEntity()[0] == null) {
				logger.error("Fail to get business " + name 
						+ " from the source registry.");
				continue;
			}
			BusinessEntity be = detail.getBusinessEntity()[0];
			
			logger.info("Publish business " + name 
					+ " into the target registry.");
			Save_business request = new Save_business();
			request.setBusinessEntity(new BusinessEntity[]{be});
			try {
				target.saveBusiness(request);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			/*
			 * Verification
			 */
			try {
				detail = target.getBusinessDetail(info.getBusinessKey());
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage());
				continue;
			}
			
			if (detail == null || detail.getBusinessEntity() == null
					|| detail.getBusinessEntity()[0] == null) {
				logger.error("Fail to get business " + name 
						+ " from the target registry.");
				continue;
			}
			BusinessEntity be2 = detail.getBusinessEntity()[0];
			if (!be.equals(be2)) {
				logger.error("Different business " + name 
						+ " between source and target.");
			}
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GrimoiresProxy uddiSource = 
			GrimoiresjUDDIWebServiceProxyFactory.getInstance().createQueryProxy(
					"http://uddi.wesc.ac.uk:8334/juddi/inquiry");
		
		GrimoiresProxy grimoiresTarget = 
			GrimoiresWebServiceProxyFactory.getInstance().createProxy(
					"http://localhost:8080/grimoires/services");
		
		new CopyRegistry(uddiSource, grimoiresTarget).copy();
	}
}

#!/bin/bash

#
#  Upload the Grimoires release.
#

GRIMOIRES_RELEASE_FILE=$HOME/grimoires/grimoires-*-src.tar.gz

echo "======== Delete previous uploaded Grimoires release ========"
ssh -l wf login.ecs.soton.ac.uk rm public_html/grimoires/grimoires*.gz

echo "======== Upload the new Grimoires release ========"
scp $GRIMOIRES_RELEASE_FILE wf@login.ecs.soton.ac.uk:/home/wf/public_html/grimoires

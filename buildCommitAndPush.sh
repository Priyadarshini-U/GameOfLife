#!/bin/bash
ant
if [ $? -eq 0 ]; then
  git add -A
  git status
  echo "Enter commit message:"
  read commitMessg
  git commit -m "$commitMessg"
  git push -u origin master
fi


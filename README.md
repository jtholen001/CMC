## CMC


## For team members only

1. Compress your old CMC folder and name it CMC_Backup (zip)
2. Delete old CMC folder
3. In Eclipse, right click on CMC project and click Delete, and check "Delete project contents on disk"
4. Go to "File" > "Import..."
5. Under "General", select "Existing Projects into Workspace"
6. Click "Next" button
7. Choose "Select archive file:" and click "Browse..." button
8. Open CMC.zip (from Jordan's email) and click "Finish"
9. Close Eclipse 
10. Go to /HOME/eclipse-workspace/CMC
11. Click on the "View" menu and check "Show Hidden Files"
12. Copy ".project" and ".classpath" files
13. Paste them outside CMC folder
14. Delete CMC folder from /HOME/eclipse-workspace
15. Open terminal, cd to /HOME/eclipse-workspace
16. Run command: git clone https://github.com/jtholen001/CMC
17. cd to /HOME/eclipse-workspace/CMC
18. Run command: git remote add upstream https://github.com/jtholen001/CMC
19. Open Eclipse and the project should be there.

## For all other users

TO ADD PROJECT TO ECLIPSE:
1. [Download](https://github.com/jtholen001/CMC/files/1900743/CMC-main.zip) our latest stable release as a zip file
2. Open Eclipse
3.. Go to "File" > "Import..."
4. Under "General", select "Existing Projects into Workspace"
5. Click "Next" button
6. Choose "Select archive file:" and click "Browse..." button
7. Open CMC-main.zip
8. Click "Finish" button

TESTING INSTRUCTIONS

1) Open AllTests.java located in CMC/test
2) Run

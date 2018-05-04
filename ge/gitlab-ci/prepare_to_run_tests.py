#!/usr/bin/env python3
# Script intended to be ran before running tests as part of GitLab CI integration.
# Clones repositories needed for running tests while using the graphical editor branch provided by GitLab.
# Accepts the directory to use as the root for all repositories as an argument.
# Creates a userspace bind to mount the graphical editor repository inside the specified root to workaround the inability 
# to configure such as part of the GitLab CI configuration.

import sys
import os
import re
from collections import namedtuple
from subprocess import call

# Constants
default_branch = 'develop' # Only used
path_to_oge_repo = os.getcwd()

Repo = namedtuple('Repo', ['url', 'branch'])
repos = [
	Repo('https://github.com/osate/alisa.git', default_branch),
	Repo('https://github.com/osate/ErrorModelV2.git', default_branch),
	Repo('https://github.com/osate/osate2-ba.git', default_branch),
	Repo('https://github.com/osate/osate2-core.git', default_branch),
	Repo('https://github.com/OpenAADL/osate2-ocarina.git', 'master'),
	Repo('https://github.com/osate/osate2-plugins.git', default_branch),
	Repo('https://github.com/smaccm/smaccm.git', default_branch),	
	]

# Command Line Arguments
if len(sys.argv) != 2:
	sys.exit("Incorrect number of arguments")
	
root_dir = sys.argv[1]

# Change Working Directory
os.chdir(root_dir)

for repo in repos:
	print("Repo: ", repo.url)
	repo_directory_path = "./" + re.search(".+/([^/]+).git", repo.url).group(1)	

	if os.path.isdir(repo_directory_path):
		call(["git", "clean", "--force"], cwd=repo_directory_path)
		call(["git", "reset", "--hard"], cwd=repo_directory_path)
		call(["git", "checkout", repo.branch], cwd=repo_directory_path)
		call(["git", "pull"], cwd=repo_directory_path)
	else:
		call(["git", "clone", "-b", repo.branch, repo.url])

# Handle binding the directory to the proper location
if os.path.exists('osate-ge'):
	call(["fusermount", "-qu", "osate-ge"])
else:
	os.mkdir("osate-ge")
call(["bindfs", "--no-allow-other", path_to_oge_repo, "osate-ge"])
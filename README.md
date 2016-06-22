# Storm Eye
This is a small CLI tool for heroes of the storm info & personal builds for heroes

# Tech stack
TODO

# Usage
TODO

# TODOs
- document
- tests
- add builds
- create/update/delete builds within the cli tool
- link build talents with extracted talents to more verbose builds presentation
- package the tool in a jar so that sbt is not needed to run
    - make a configuration file independent of the package
    - extract the builds.json
        - so that every person can create their own json with their builds
    - extract the heroes.json
        - so that then a new command can be added to just download it for updates
        - a new command to check for updates
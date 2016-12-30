# Requirements

Internet connectivity


# Instructions

Unzip files in desired folder

To check unit tests are passing run:
On *nix from terminal: `./gradlew clean test`
On Windows from commandline: `gradlew clean test`

To run program against a new maze copy new maze to ./src/main/resources and then run: 
On *nix from terminal: `./gradlew clean run -Pfilename="<<filename>>"`
On Windows from commandline: `gradlew clean run -Pfilename="<<filename>>"`
where <<filename>> is replaced by the new maze's filename

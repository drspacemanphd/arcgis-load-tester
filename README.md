# Hub Load Testing using Gatling

This is a small repo that can be used to load test local or deployed apps using [Gatling](https://https://gatling.io/), a load testing framework in Scala. The scenario-based framework provides a more full-featured interface for request loads including pausing, ramp up/down, parent -> child sequential scenarios, etc.

Gatling generally requires a JDK (or OpenJDK) installation. Though not required, I've based this repo on their Maven plugin.

## Quick Start
1. Homebrew install OpenJDK and Maven.
  - `brew install openjdk`
  - `brew install maven`

2. Clone the project and compile
  - `mvn compile`
  - The first time this is run, dependencies outlined in `pom.xml` will be downloaded locally.

3. Run the example load test
  - Load tests should be placed in the `src/test/scala/hub/` directory, An example `Example.scala` is there to build from. See gatling's documentation to configure the scenario that you desire.
  - `mvn gatling:test -Dgatling.simulationClass=hub.Example`

4. Examine results.
  - Look at the command-line output for basic results. Also notice that an html file containing the results has been created (and timestamped) under the `target` folder.

5. Modify Example.scala to your liking OR create another test file based on it. Remember to then replace the `gatling.simulationClass` variable above to be `-Dgatling.simulationClass=hub.<YOUR_CLASS_NAME>`



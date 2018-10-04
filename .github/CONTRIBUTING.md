## Development and Testing

To run the project locally, clone the repository and install the dependencies.

```
git clone https://github.com/amadeus4dev/amadeus-java.git
cd amadeus-java
gradle
```

Make sure you have Gradle installed as well.

### About Lombok

This library uses [Lombok](https://projectlombok.org/) for simplifying the code base. To use this in your editor, make sure to follow the instructions on their site.

For example, for InteliJ follow [these instructions](https://projectlombok.org/setup/intellij).

### Running tests

To run tests, simply run `./gradlew test`

We are trying to keep 100% coverage, so keep an eye on the `coverage` folder for an overview of the coverage.

### Building

To build the jar run `./gradlew clean build`

### Using a library locally

To use a library locally as a dependency, simply link to this library in your Gradle project by path:

```js
compile files('/path/to/libs/amadeus-java-1.0.1-SNAPSHOT.jar')
```

### Releasing

To make a new release, follow the following steps:

- [ ] Update the version in `Amadeus.java` using semver rules
- [ ] Update the `CHANGELOG.md` with the new version
- [ ] Push all changes and ensure all tests pass on Travis
- [ ] Tag your release in git using `git --tag vX.X.X`
- [ ] Push the new tag `git push --tags`
- [ ] Update the [Releases](https://github.com/amadeus4dev/amadeus-java/releases) tab on GitHub with a new release for the tag, copying the description from the `CHANGELOG.md`

Travis will bow build the gem and release it to RubyGems.

## How to contribute to the Amadeus Java SDK

#### **Did you find a bug?**

* **Ensure the bug was not already reported** by searching on GitHub under [Issues](https://github.com/amadeus4dev/amadeus-java/issues).

* If you're unable to find an open issue addressing the problem, [open a new one](https://github.com/amadeus4dev/amadeus-java//issues/new). Be sure to include a **title and clear description**, as much relevant information as possible, and a **code sample** or an **executable test case** demonstrating the expected behavior that is not occurring.

#### **Did you write a patch that fixes a bug?**

* Open a new GitHub pull request with the patch.

* Ensure the PR description clearly describes the problem and solution. Include the relevant issue number if applicable.

#### **Do you intend to add a new feature or change an existing one?**

* Suggest your change [in a new issue](https://github.com/amadeus4dev/amadeus-java/issues/new) and start writing code.

* Make sure your new code does not break any tests and include new tests.

* With good code comes good documentation. Try to copy the existing documentation and adapt it to your needs.

* Close the issue or mark it as inactive if you decide to discontinue working on the code.

#### **Do you have questions about the source code?**

* Ask any question about how to use the library by [raising a new issue](https://github.com/amadeus4dev/amadeus-java/issues/new).

#### **Do you want to contribute to the documentation?**

Excellent, to get start developing this library ensure you have Java 7+ installed and clone the repository.

Then, you should be able to create the docs.

```sh
./gradlew javadoc
```

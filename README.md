# demo-percy-java

Project based on the [Percy Example](https://github.com/percy/example-percy-java-selenium.git) for Java + Selenium. 

## Instalation
1. Open the terminal
2. Clone the project: `git clone https://github.com/karlambsilva/demo-percy-java`
3. Go to the project folder: `cd demo-percy-java`
4. Run the following command: `make install`
5. Sign in or create a new account at percy.io
6. Create a new project
7. Copy the token variable
8. Back to the terminal, run one of the following commands: 
For unix: `export PERCY_TOKEN="<your token here>"`
For Windows, Shell: `set PERCY_TOKEN="<your token here>"` or PowerShell: `$Env:PERCY_TOKEN="<your token here>"`
9. Execute the tests: `make test`

Please check the [official documentation](https://docs.percy.io/docs/java-selenium-testing-tutorial) for more details about the installation process.

## Notes

1. The site used on the tests is available on src/main/resources and deployed to GitHub Pages. Basically, there are 2 pages with some minor differences to evaluate the effectiveness of the tool:
[Regular page](https://karlambsilva.github.io/demo-percy-java/) and [page with minor changes](https://karlambsilva.github.io/demo-percy-java/index-with-changes.html);
1. **main** is the base branch for the comparison, but there are 2 more branches: **dev/percy-passing** and **dev/percy-failing** (which points to the page with the changes)

## Limitations or Bugs? (Needs more investigation)
1. Comparison process take some time
2. Take screenshot of a specific scope is not working.
1. How to proper use the ignored regions?

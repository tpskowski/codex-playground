# Dice WebApp

This project demonstrates compiling Java code to JavaScript using TeaVM and serving the result as a static web app. The Java code calculates spell casting odds by iterating over all possible dice combinations.

## Building

The Java code is located in the `webapp` directory. To generate the HTML and JavaScript bundle, run:

```bash
cd webapp
mvn package
```

The build will produce `src/main/resources/webapp/js/app.js`. Open `src/main/resources/webapp/index.html` in a browser to use the calculator.

## Deployment

The contents of `src/main/resources/webapp` can be pushed to GitHub Pages or any static host to serve the application.

## GitHub Pages Workflow

This repository includes a GitHub Actions workflow at `.github/workflows/deploy.yml`.
It builds the project using:

```bash
mvn -f webapp/pom.xml package
```

After a successful build the workflow deploys `webapp/src/main/resources/webapp`
to the `gh-pages` branch using `peaceiris/actions-gh-pages`. Pushing to `main`
will automatically publish the updated static site.

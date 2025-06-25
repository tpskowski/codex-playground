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

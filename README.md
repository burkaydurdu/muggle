[![Netlify Status](https://api.netlify.com/api/v1/badges/54b34e98-3dd6-4402-9655-2df504499e99/deploy-status)](https://app.netlify.com/sites/muggle/deploys)

### Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```script
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.

### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.

### Building for production

```
lein clean
lein package
```

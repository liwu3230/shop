export default {
  hash: true,
  base: '/',
  publicPath: '/',
  headScripts: [
    `window.routerBase = "/";`,
    `window.publicPath =window.resourceBaseUrl || "/";`,
  ],
};

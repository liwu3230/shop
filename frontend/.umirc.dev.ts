const { execSync } = require('child_process');
const fs = require('fs');
const path = require('path');

function parseAppPackage() {
  return JSON.parse(
    fs.readFileSync(path.resolve(__dirname, 'package.json')).toString(),
  );
}

function getLastCommitId() {
  return execSync('git rev-parse HEAD', { timeout: 1000 }).toString().trim();
}

export default {
  define: {
    isDev: true,
  },
  base: '/',
  publicPath: '/',
  headScripts: [
    `window.routerBase = "/";`,
    `window.publicPath =window.resourceBaseUrl || "/";`,
  ],
  hash: true,
  devtool: 'source-map',
  // chainWebpack(config) {
  //   config.resolve.extensions.add('tsx');
  // },
};

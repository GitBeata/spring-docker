//const { defineConfig } = require('@vue/cli-service')
//module.exports = defineConfig({

// transpileDependencies: true
//})

module.exports = {
  devServer: {
    proxy: {
      'api': {//każde przekierowanie zaaczynające się od api będzie przekierowane      
        target: 'http://localhost:8080', // docelowy backen działa na porcie 8080
        changeOrigin: true, //podmiana nagłówka origin w żądaniu
        pathRewrite: { '^/api': '' }, // usuwamy /api  z url przed przekazaniem do backendu
      },
    }
  }
}
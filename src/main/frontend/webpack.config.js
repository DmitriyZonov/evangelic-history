const path = require('path');
const { WebpackManifestPlugin } = require('webpack-manifest-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');

module.exports = {
    entry: {
        main: './main.js',
        burger_menu: '../resources/static/js/burger_menu.js',
        hiding_elements: '../resources/static/js/hiding-elements.js',
        up_button: '../resources/static/js/up-button.js',
        about: '../resources/static/css/about.css',
        announcement: '../resources/static/css/announcement.css',
        biographies: '../resources/static/css/biographies.css',
        biography: '../resources/static/css/biography.css',
        event: '../resources/static/css/event.css',
        events: '../resources/static/css/events.css',
        history: '../resources/static/css/history.css',
        history_article: '../resources/static/css/history_article.css',
        index: '../resources/static/css/index.css',
        privacy_policy: '../resources/static/css/privacy_policy.css',
    },
    output: {
        // Теперь сборка идёт прямо в папку nginx
        path: path.resolve(__dirname, '../../../../../var/www/evangelic-history/dist'),
        filename: '[name].[contenthash].js',
        clean: true,
        publicPath: '/dist/',
    },
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: [MiniCssExtractPlugin.loader, 'css-loader'],
            },
        ],
    },
    plugins: [
        new MiniCssExtractPlugin({
            filename: '[name].[contenthash].css',
        }),
        new WebpackManifestPlugin({
            fileName: 'manifest.json',
            publicPath: '/dist/',
        }),
    ],
    mode: 'production',
};
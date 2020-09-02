const path = require('path');
module.exports = {
	devServer: {
		overlay: false,
	},
	outputDir: path.resolve(__dirname, '../src/main/resources/static'),
};

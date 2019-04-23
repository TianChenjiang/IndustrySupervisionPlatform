var wxCharts = require('../../utils/wxcharts.js');
var app = getApp();
var lineChart = null;

Page({
  data: {
    buffer: {}
  },
  touchHandler: function (e) {
    console.log(lineChart.getCurrentDataIndex(e));
    lineChart.showToolTip(e, {
      // background: '#7cb5ec',
      format: function (item, category) {
        return category + ' ' + item.name + ':' + item.data
      }
    });
  },


  createData: function () {
    var categories = [];
    var data = [];
    for (var i = 0; i < this.data.buffer.length; i++) {
      var record = this.data.buffer[i];
      categories.push(record.year + '-' + record.month + '-' + record.day);
      data.push(record.production);
    }
    return {
      categories: categories,
      data: data
    }
  },
  updateData: function () {
    var simulationData = this.createData();
    var series = [{
      name: '产量1',
      data: simulationData.data,
      format: function (val, name) {
        return val.toFixed(2) + '万';
      }
    }];
    lineChart.updateData({
      categories: simulationData.categories,
      series: series
    });
  },
  onLoad: function (e) {
    // this.getDataFromCloud()
    var windowWidth = 400;
    try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }

    var simulationData = this.createData();//important
    lineChart = new wxCharts({
      canvasId: 'lineCanvas',
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      // background: '#f5f5f5',
      series: [{
        name: '产量1',
        data: simulationData.data,
        format: function (val, name) {
          return val.toFixed(2) + '万';
        }
      }, {
        name: '产量2',
        data: [2, 0, 0, 3, null, 4, 0, 0, 2, 0],
        format: function (val, name) {
          return val.toFixed(2) + '万';
        }
      }],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '产量 (吨)',
        format: function (val) {
          return val.toFixed(1);
        },
        min: 0
      },
      width: windowWidth-50,
      height: 180,
      dataLabel: false,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
    });
  },

//云数据库获取数据
  // getDataFromCloud: function(){
  //   const db = wx.cloud.database();
  //   const productionCollection = db.collection('Production')
  //   const _ = db.command
  //   productionCollection.where({
  //     month: _.eq(1).or(_.eq(2))
  //   }).get({
  //     success: function(res){
  //       this.setData({ buffer: res.data })
  //       console.log(res.data)
  //       console.log(res.data.length)
  //     }
  //   })
  // }
});
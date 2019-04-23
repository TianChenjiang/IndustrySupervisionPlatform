var wxCharts = require('../../utils/wxcharts.js');
var app = getApp();
var lineChart1 = null;
var lineChart2 = null;

Page({
  data: {
    deviceId: null,
    buffer: {}
  },
  touchHandler1: function (e) {
    console.log(lineChart1.getCurrentDataIndex(e));
    lineChart1.showToolTip(e, {
      // background: '#7cb5ec',
      format: function (item, category) {
        return category + ' ' + item.name + ':' + item.data
      }
    });
  },
  touchHandler2: function (e) {
    console.log(lineChart2.getCurrentDataIndex(e));
    lineChart2.showToolTip(e, {
      // background: '#7cb5ec',
      format: function (item, category) {
        return category + ' ' + item.name + ':' + item.data
      }
    });
  },

  createData: function () {
    var categories = [];
    var data = [];
    for (var i = 1; i < 12; i++) {
      var record = 10 + Math.random()*20;
      categories.push('2019' + '-' + i + '-' + '1');
      data.push(record);
    }
    return {
      categories: categories,
      data: data
    }
  },
  // updateData: function () {
  //   var simulationData = this.createData();
  //   var series = [{
  //     name: '设备温度',
  //     data: simulationData.data,
  //     format: function (val, name) {
  //       return val.toFixed(2) + '摄氏度';
  //     }
  //   }];
  //   lineChart1.updateData({
  //     categories: simulationData.categories,
  //     series: series
  //   });
  // },


  onLoad: function (e) {
    // wx.request({
    //   url: 'http://api.nlecloud.com/users/login',
    //   data: {
    //     Account: 18852003606,
    //     Password: 'dachuang'
    //   },
    //   method: 'POST',
    //   success: function (res) {
    //     console.log(res.data.ResultObj.AccessToken)
    //     app.globalData.token = res.data.ResultObj.AccessToken
    //   }
    // })


    var windowWidth = 400;
    try {
      var res = wx.getSystemInfoSync();
      windowWidth = res.windowWidth;
    } catch (e) {
      console.error('getSystemInfoSync failed!');
    }

    var simulationData = this.createData();//important
    lineChart1 = new wxCharts({
      canvasId: 'lineCanvas1',
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      // background: '#f5f5f5',
      series: [
      {
        name: '设备温度',
        data: simulationData.data,
        format: function (val, name) {
          return val.toFixed(2) + '℃';
        }
      }
      ],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '温度 (℃)',
        format: function (val) {
          return val.toFixed(1);
        },
        min: 0
      },
      width: windowWidth - 50,
      height: 180,
      dataLabel: false,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
    });
    lineChart2 = new wxCharts({
      canvasId: 'lineCanvas2',
      type: 'line',
      categories: simulationData.categories,
      animation: true,
      // background: '#f5f5f5',
      series: [
        {
          name: '设备湿度',
          data: simulationData.data,
          format: function (val, name) {
            return val.toFixed(2) + '%';
          }
        }
      ],
      xAxis: {
        disableGrid: true
      },
      yAxis: {
        title: '湿度(%)',
        format: function (val) {
          return val.toFixed(1);
        },
        min: 0
      },
      width: windowWidth - 50,
      height: 180,
      dataLabel: false,
      dataPointShape: true,
      extra: {
        lineStyle: 'curve'
      }
    });
  },

  deviceIdInput: function (event) {
    this.setData({ deviceId: event.detail.value })
    console.log(this.data.deviceId)
  },

  //get data from backend
  updateData: function(){
    this.getTemperature();
    this.getHumidity();
  },

  getTemperature: function(){
    wx.request({
      url: 'http://api.nlecloud.com/users/login',
      data: {
        Account: 18852003606,
        Password: 'dachuang'
      },
      method: 'POST',
      success: function(res){
        console.log(res.data.ResultObj.AccessToken)
        app.globalData.token = res.data.ResultObj.AccessToken
      }
    })

    var categories = [];
    var record = [];
    wx.request({
      url: 'http://api.nlecloud.com/devices/' + this.data.deviceId + '/Datas/Grouping',
      header: {
        'content-type': 'application/json',
        // 'Authorization': app.globalData.token
        // 'token': app.globalData.token
      },
      data: {
        ApiTags: 'Temperature',
        StartDate: '2019-04-20 00:00:00',
        AccessToken: app.globalData.token
      },
      method: 'GET',
      success: function(res){
        var datalist = res.data.ResultObj.DataPoints[0].PointDTO;
        for(var i=0;i<datalist.length;i++){
          categories.push(datalist[i].RecordTime)
          record.push(datalist[i].Value)
        }
        console.log(res.data.ResultObj.DataPoints[0])
        console.log(categories)
        console.log(record)
        var series = [{
          name: '设备温度',
          data: record,
          format: function (val, name) {
            return val.toFixed(2) + '摄氏度';
          }
        }];
        lineChart1.updateData({
          categories: categories,
          series: series
        });
      }
    })
  },

  getHumidity: function(){
    wx.request({
      url: 'http://api.nlecloud.com/users/login',
      data: {
        Account: 18852003606,
        Password: 'dachuang'
      },
      method: 'POST',
      success: function (res) {
        console.log(res.data.ResultObj.AccessToken)
        app.globalData.token = res.data.ResultObj.AccessToken
      }
    })

    var categories = [];
    var record = [];
    wx.request({
      url: 'http://api.nlecloud.com/devices/' + this.data.deviceId + '/Datas/Grouping',
      header: {
        'content-type': 'application/json',
        // 'Authorization': app.globalData.token
        // 'token': app.globalData.token
      },
      data: {
        ApiTags: 'Humidity',
        StartDate: '2019-04-20 00:00:00',
        AccessToken: app.globalData.token
      },
      method: 'GET',
      success: function (res) {
        var datalist = res.data.ResultObj.DataPoints[0].PointDTO;
        for (var i = 0; i < datalist.length; i++) {
          categories.push(datalist[i].RecordTime)
          record.push(datalist[i].Value)
        }
        console.log(res.data.ResultObj.DataPoints[0])
        console.log(categories)
        console.log(record)
        var series = [{
          name: '设备湿度',
          data: record,
          format: function (val, name) {
            return val.toFixed(2) + '%';
          }
        }];
        lineChart2.updateData({
          categories: categories,
          series: series
        });
      }
    })    
  }
});
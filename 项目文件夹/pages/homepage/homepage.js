
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    buttonlist:[
      {
        func:'clickTo_production',
        color:'green',
        title:'产量监测',
        detail:'查看产量相关的详细数据'
      },
      {
        func: 'clickTo_device',
        color:'red',
        title:'设备维护监测',
        detail:'查看设备状态详细数据'
      },
      {
        func: 'clickTo_station_1',
        color:'blue',
        title:'工位Ⅰ监测',
        detail:'查看工位Ⅰ到达产品数量等详细数据',
      },
      {
        func: 'clickTo_station_2',
        color:'yellow',
        title:'工位Ⅱ监测',
        detail:'查看工位Ⅱ到达产品数量等详细数据'
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
    
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
    
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
    
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
    
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    
  },

  /**
   * 判断有没有登录
   */

  clickTo_production:function(){
    if (!app.globalData.hasLogin) {
      wx.redirectTo({
        url: '../login/login',
      })
    }else{
      wx.navigateTo({
        url: '../production/production',
      })
    }
  },
  clickTo_device: function () {
    if (!app.globalData.hasLogin) {
      wx.redirectTo({
        url: '../login/login',
      })
    } else {
      wx.navigateTo({
        url: '../device/device',
      })
    }
  },
  clickTo_station_1: function () {
    if (!app.globalData.hasLogin) {
      console.log('hhhhh')
      wx.redirectTo({
        url: '../login/login',
      })
    } else {
      wx.navigateTo({
        url: '../station_1/station_1',
      })
    }
  },
  clickTo_station_2: function () {
    if (!app.globalData.hasLogin) {
      wx.redirectTo({
        url: '../login/login',
      })
    } else {
      wx.navigateTo({
        url: '../station_2/station_2',
      })
    }
  }
})
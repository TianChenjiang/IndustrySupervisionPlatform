
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    username:null,
    password:null,
    identity:null,
    items: [
      { name: 'user', value: '用户', checked: 'true'},
      { name: 'administrator', value: '管理员'},
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

  radioChange:function(event) {
    this.setData({identity:event.detail.value})
  },
  /**
   * 点击登录
   */
  loginClick:function(){

    //todo 服务器判断账号密码是否匹配
  
    app.globalData.userinfo = {
      username:this.data.username,
      password:this.data.password,
      identity:this.data.identity
    }

    wx.redirectTo({
      url: '../userCenter/userCenter',
    })

  },
  usernameInput:function(event){
    this.setData({username:event.detail.value})
  },
  passwordInput:function(event){
    this.setData({password:event.detail.value})
  }
})
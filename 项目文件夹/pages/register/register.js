wx.cloud.init();
const db = wx.cloud.database();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    username: null,
    password: null,
    passwordconfirm: null,
    identity: 'user',
    usernameValid: true,
    showWarning: false,
    items: [
      { name: 'user', value: '用户', checked: 'true', disabled: 'false' },
      { name: 'administrator', value: '管理员', disabled: 'true'},
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
   * 身份切换，目前只开放用户注册
   */
  // radioChange: function (event) {
  //   this.setData({ identity: event.detail.value })
  // },

  usernameInput: function (event) {
    this.setData({ username: event.detail.value })
  },
  passwordInput: function (event) {
    this.setData({ password: event.detail.value })
  },
  passwordConfirm: function (event){
    this.setData({ passwordconfirm: event.detail.value })
  },
  /**
   * 数据库获取用户名，若存在，发出警告信息
   */
  userNameBlur: function (){
    const userCollection = db.collection('User');
    const _ = db.command;
    userCollection.where({
      _username: _.eq(this.data.username)
    }).get({
      success: function () {
        //显示用户名存在并警告
        this.setData({
          usernameValid: false,
          showWarning: true
        })
      },
      fail: function(){
        //警告消失，用户名合理
        this.setData({
          usernameValid: true,
          showWarning: false
        })
      }
    })
  },
  /**
   *注册点击按钮事件 
   */
  registerClick: function (){
    if(this.data.usernameValid == true){//判断用户名是否合适
      if (this.data.username == null || this.data.password == null 
        || this.data.passwordconfirm == null) {//输入框为空
        wx.showToast({
          title: '输入框不能为空',
          image: '../images/gantanhao.jpg'
        })
      }else if(this.data.password != this.data.passwordconfirm){//确认密码错误
        wx.showToast({
          title: '确认密码错误',
          icon: 'none',
          //回调函数，清空输入框内容
          success: function(){
            this.setData({
              username: null,
              password: null,
              passwordconfirm: null
            })
          }
        })
      }else{
        const userCollection = db.collection('User');
        userCollection.add({
          data: {
            _username: this.data.username,
            _password: this.data.password
          },
          success: function(){
            wx.showToast({
              title: '注册成功！',
              icon: 'success',
              duration: 1000
            })
          }
        })
        //回到登录界面
        wx.redirectTo({
          url: '../login/login',
        })
        
        // const userCollection = db.collection('User');
        // const _ = db.command;
        // userCollection.where({
        //   _username: _.eq(this.data.username)
        // }).get({
        //   success: function(){
        //     wx.showToast({
        //       title: '用户名已存在',
        //       icon: 'none',
        //       success: function () {
        //         this.setData({
        //           username: null,
        //           password: null,
        //           passwordconfirm: null
        //         })
        //       }
        //     })
        //   },
        //   fail: function(){

        //   }
        // })
      }
    }
  }
})
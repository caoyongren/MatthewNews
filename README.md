# SimpleNews
基于Material Design和MVP的新闻客户端
***
### 基本设计
  - 1. 在抽屉中分为四个模块;
    - 1. 新闻 -- news
    - 2. 图片 -- images
    - 3. 天气 -- weather
    - 4. 关于 -- about
  - 2. 每一个模块都应用MVP的思想:
    - news
      - model -- 为UI提供数据 or 保存UI传下来的数据.
      - presenter -- model 和 view之间的操作者; 逻辑控制,从model处取数据, 运算和转化, 最后用View来展示;
      - view -- ui 单纯的展示数据, 响应用户操作转发给presenter来处理.
      - 包的划分:
        - 整体划分出MVP后,还需要: beans utils widget
        - beans: 实体类; 
        - utils: 工具类;
        - widget: 小部件; 类似装饰线;
        - constants: 常亮字符串
  - 3. MVP具体应用
        
 


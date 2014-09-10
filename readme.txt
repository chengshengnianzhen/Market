一共9个功能，我是按照位置的功能，在写程序。比如中间的是就是center
按照排列，第一个是aboveleft，第二个是above，第三个是aboveright
	第四，centerleft，第五，center，第六，centerright
	第七，bottomleft，第八，botttom，第九，bottomright
里面导入了百度的地图包，导入了google的二维码包（Zxing）
就是按照给我的文档写的每个程序
第一个，aboveleft显示要查询的页面，里面有两个botton一个是查询，一个是二维码的按钮，程序里有说明。
aboveleft_qr就是二维码的页面，具体我是在百度一点一点写的，这个就是改那个传入数据的地方，传到要显示结果的页面。
aboveleft_result显示结果，将显示的数据显示出来。

第二个，above  4个按钮，拍照，摄像，上传和下载，下载我没有写，拍照和摄像都是保持到本地，然后上传的界面也写了
上传的界面above_upload

第三个，aboveright显示的是自己的位置，同时每个显示不会上传数据应为要在第四个功能显示出来，故可以在4个的时候显示数据。

第四个，centerleft 上面显示自己的位置和其他人的位置，同时下面显示出每个人的位置信息。要计算和显示出来，同还有一个呼叫按钮，点击
即可呼叫当前的用户的电话。
传出的数据就是 当前用户的名字和位置，服务器计算与其他人的位置信息，并回传给用户，然后显示出来，回传的信息包括用户，距离和电话
centerleft_myadapter是定义listview格式。
centerleft_myadapter_usermessage是格式

第五个，center是建立问卷，问卷已经建立好了，看看怎么上传，我可以保存成本地的txt，然后你可以上传，在服务器查看

第六个，center是查询问卷，建立的写好了，。就是简单地下载txt查看。

第七个，bottomleft是程度的上传，数据库弄好，直接上传就可以了。

第八个，没开放。

第九个，页面完成。


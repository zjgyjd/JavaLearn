 消息按行读取
            1.register:<username>  例如:register:张三                        注册
            2.groupChat:<message>   例如:groupChat:大家好                    群聊
            3.privateChat:<username>:<message> 例如:privateChat:张三:你好    私聊
            4.bye


 3.1.1利用命令行的交互式输入输出,需要服务端能够进行一下操作:
 1.在服务端进行注册和登录;
 2.客户端通过服务端可以和在线所有客户发起群聊
 3.通过服务端和指定客户进行私聊
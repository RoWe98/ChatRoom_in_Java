# ChatRoom_in_Java
使用java Socket类编写的多人聊天软件


利用Java的Socket类并使用TCP协议完成聊天室

#ServerSocket 类的构造方法：

ServerSocket() 创建未绑定的服务器套接字

ServerSocket(int port) 创建绑定到指定端口的服务器套接字 

ServerSocket(int port，int backlog) 创建服务器套接字并将其绑定到指定的本地端口	号，并指定了积压。 

ServerSocket(int port，int backlog，InetAddress bindAddr) 创建一个具有指定端口	的服务器，侦听backlog和本地IP地址绑定。 





#Socket类的构造方法:
Socket() 创建一个未连接的套接字，并使用系统默认类型的SocketImpl。

Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定	端口号。

Socket(InetAddress address, int port, InetAddress localAddr, int localPort) 创建套接	字并将其连接到指定的远程端口上指定的远程地址。

Socket(Proxy proxy) 创建一个未连接的套接字，指定应该使用的代理类型（如果有	的话），无论其他任何设置如何。

Socket(SocketImpl impl) 使用用户指定的SocketImpl创建一个未连接的Socket

Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号。

Socket(String host, int port, InetAddress localAddr, int localPort)创建套接字并将其	连接到指定远程端口上的指定远程主机。 



Socket通信的基本原理：

思路：客户端使用Socket类新建一个Client对象，服务端使用ServerSocket类新建一个Server对象，使用IO流完成数据的传输和交互，客户端的输出流为服务端的输入流；服务端的输出流为客户端的输入流。


Socket编程使用TCP协议的基本步骤：

    • 服务器创建ServerSocket，在指定端口监听并处理请求

    • 客户端创建socket，向服务器发送请求

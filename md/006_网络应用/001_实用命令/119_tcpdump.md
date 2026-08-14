---
show: step
version: 1.0
enable_checker: true
---

# 实验标题

## 实验介绍
以下是一些简单使用 tcpdump 的小例子：

1. 针对特定网口抓包

使用 -i 选项指定要监听的网络接口，如监听 eth0 接口的所有数据包：
sudo tcpdump -i eth0
执行该命令后，tcpdump 会开始抓取通过 eth0 接口的数据包，并在终端显示相关信息，包括时间戳、协议、源 IP 和端口、目的 IP 和端口等 。若想停止抓包，按 Ctrl + C 即可。

2. 抓取指定数目的包

结合 -c 选项指定抓取数据包的数量，例如只抓取 eth0 接口上的 5 个数据包：
sudo tcpdump -c 5 -i eth0
当抓到指定数量（这里是 5 个）的数据包后，tcpdump 会自动停止抓包并结束运行。

3. 将抓到的包写入文件

利用 -w 选项把捕获的数据包保存到文件中，方便后续分析。比如将 eth0 接口抓到的数据包保存到 capture.pcap 文件：
sudo tcpdump -w capture.pcap -i eth0
生成的 capture.pcap 文件可以使用 Wireshark 等专业的网络分析工具打开查看详细信息。

4. 读取已保存的抓包文件

使用 -r 选项读取之前用 -w 选项保存的抓包文件，例如读取 capture.pcap 文件：
sudo tcpdump -r capture.pcap
此时 tcpdump 会在终端展示文件中数据包的相关信息。

5. 抓包时不进行域名解析

默认情况下 tcpdump 会尝试将 IP 地址解析为域名，使用 -n 选项可禁止这种解析，直接显示 IP 地址。比如在 eth0 接口抓包且不进行域名解析：
sudo tcpdump -n -i eth0
这样在输出结果中看到的将是 IP 地址，而不是对应的域名，在一些场景下能加快抓包显示速度 。

6. 指定抓包的协议类型

可以指定只抓取某种协议的数据包，例如只抓取 arp 协议的包：
sudo tcpdump -i eth0 arp
或者只抓取 tcp 协议的包：
sudo tcpdump -i eth0 tcp
7. 指定抓包端口

若只想抓取特定端口的数据包，以端口 80 为例（HTTP 协议常用端口）：
sudo tcpdump -i eth0 port 80
若要抓取多个端口（如 80 和 443 端口 ），可以使用逻辑或关系：
sudo tcpdump -i eth0 port 80 or port 443
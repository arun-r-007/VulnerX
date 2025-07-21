CREATE DATABASE ai_security_system;
use ai_security_system;
CREATE TABLE scanner_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    web_name VARCHAR(100),
    port VARCHAR(10),
    state VARCHAR(20),
    service VARCHAR(50),
    result TEXT
);

drop table scanner_data;


select * from scanner_data;






1	scanme.nmap.org	22	open	ssh	Safe
2	scanme.nmap.org	25	filtered	smtp	Unsafe
3	scanme.nmap.org	80	filtered	http	Unsafe
4	scanme.nmap.org	135	filtered	msrpc	Unsafe
5	scanme.nmap.org	139	filtered	netbios-ssn	Unsafe
6	scanme.nmap.org	179	filtered	bgp	Unsafe
7	scanme.nmap.org	445	filtered	microsoft-ds	Unsafe
8	scanme.nmap.org	646	filtered	ldp	Unsafe
9	google.com	80	open	http	Safe
10	google.com	443	open	https	Safe
11	localhost	80	open	http	Safe
12	localhost	135	open	msrpc	Safe
13	localhost	443	open	https	Safe
14	localhost	445	open	microsoft-ds	Safe
15	localhost	3306	open	mysql	Safe
16	localhost	8080	open	http-proxy	Safe
17	dns.google	53	open	domain	Safe
18	dns.google	443	open	https	Safe
19	s3.amazonaws.com	80	open	http	Safe
20	s3.amazonaws.com	443	open	https	Safe
21	twitter.com	80	open	http	Safe
22	twitter.com	443	open	https	Safe
23	stackoverflow.com	80	open	http	Safe
24	stackoverflow.com	443	open	https	Safe
25	youtube.com	80	open	http	Safe
26	youtube.com	443	open	https	Safe
27	bing.com	80	open	http	Safe
28	bing.com	443	open	https	Safe
29	github.com	22	open	ssh	Safe
30	github.com	443	open	https	Safe
31	ec2-34-206-39-153	22	open	ssh	Safe
32	ec2-34-206-39-153	80	open	http	Safe
33	raw.githubusercontent.com	443	open	https	Safe
34	mail.google.com	443	open	https	Safe
35	mail.google.com	993	open	imaps	Safe
36	facebook.com	80	open	http	Safe
37	facebook.com	443	open	https	Safe
					
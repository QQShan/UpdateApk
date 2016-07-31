bzip2包中文件来来自：
http://www.bzip.org/downloads.html

这个包中的sqq.c和sqq.h是自己写的测试的，一开始以为需要在android.mk下的LOCAL_SRC_FILES声明所有.c文件
测试之后发现不用
如果需要生成so文件好像所有的.c文件都要声明一遍

LOCAL_ALLOW_UNDEFINED_SYMBOLS := true并没有什么吊用
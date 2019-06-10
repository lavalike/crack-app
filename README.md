# APK反编译
### 配置apktool
[https://ibotpeaches.github.io/Apktool/install/](https://ibotpeaches.github.io/Apktool/install/)

### 反编译
执行以下命令，生成crack目录  
> apktool d crack.apk

### 修改内容
用AndroidStudior打开crack目录，修改内容  
> vX 都是指寄存器  

打LOG 
<pre>
const-string vX, "TAG"
invoke-static {vX,vX}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
</pre>

Toast  
<pre>
const/4 v0, 0x0
const-string vX, "\u60a8\u672a\u6210\u5e74"
invoke-static {p0, vX, v0}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
move-result-object vX
invoke-virtual {vX}, Landroid/widget/Toast;->show()V
</pre>

### 重打包
执行以下命令，生成未签名的apk  
> apktool b crack -o crack_unsigned.apk

### zip对齐  
进入build tools目录  
> /Users/wangzhen/Library/Android/sdk/build-tools/28.0.3  

执行zipalign命令  
> ./zipalign -v -p 4 crack_unsigned.apk crack_aligned_unsigned.apk

### 重新签名
进入build tools/lib目录  
> /Users/wangzhen/Library/Android/sdk/build-tools/28.0.3/lib

进行签名  
> java -jar apksigner.jar sign  --ks 签名路径  --ks-key-alias 别名  --ks-pass pass:KeyStore密码  --key-pass pass:alias对应密码  --out crack_aligned_signed.apk  crack_aligned_unsigned.apk

### 检查apk是否已经签名
> java -jar apksigner.jar verify -v crack_aligned_unsigned.apk
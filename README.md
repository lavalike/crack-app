# APK反编译
### 配置apktool
[https://ibotpeaches.github.io/Apktool/install/](https://ibotpeaches.github.io/Apktool/install/)

### 反编译
执行 **apktool d crack.apk**，生成crack目录

### 修改内容
用AndroidStudior打开crack目录，修改内容

### 重打包
执行 **apktool b crack -o crack_unsigned.apk**，生成未签名的apk

### zip对齐  
进入 **/Users/wangzhen/Library/Android/sdk/build-tools/28.0.3**  

执行 **./zipalign -v -p 4 crack_unsigned.apk crack_aligned_unsigned.apk**

### 重新签名
进入 **/Users/wangzhen/Library/Android/sdk/build-tools/28.0.3/lib**

执行 **java -jar apksigner.jar sign  --ks 签名路径  --ks-key-alias 别名  --ks-pass pass:KeyStore密码  --key-pass pass:alias对应密码  --out crack_aligned_signed.apk  crack_aligned_unsigned.apk**

### 检查apk是否已经签名
执行 **java -jar apksigner.jar verify -v crack_aligned_unsigned.apk**
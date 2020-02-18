import java.util.Date;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/18
 * @Time: 22:12
 **/
//第一步：创建区块类及其属性
public class Block {

   public String hash; //数字签名
   public String previousHash;//前一区块的哈希
   private String data;//区块数据 our data will be a simple message.
   private long timeStamp;//时间戳as number of milliseconds since 1/1/1970.

 //block 构造函数

 public Block(String previousHash, String data) {
  this.previousHash = previousHash;
  this.data = data;
  this.timeStamp=new Date().getTime();
  //第四步 hash值获取--调用方法。Making sure we do this after we set the other values.
  this.hash=calculateHash();

 }

// 第三步：计算hash
 public String calculateHash(){
   String calculatedhash=StringUtil.applySha256(
    previousHash+Long.toString(timeStamp)+data);
     return calculatedhash;
 }
}

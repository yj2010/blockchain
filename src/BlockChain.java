import java.util.ArrayList;
import com.google.gson.GsonBuilder;

/**
 * Created By IDEA
 *
 * @Author: YJ
 * @Date: 2020/2/18
 * @Time: 22:52
 **/
public class BlockChain {
// 第六步 1
 public static ArrayList<Block> blockchain=new ArrayList<Block>();
 public static void main(String[] args) {
/*//  第五步：测试
// 每个区块都根据自己的信息和前一区块的签名，且拥有了自己的数字签名
  Block genesisBlock=new Block("这是第一个区块链","0");
  System.out.println("区块1的hash："+genesisBlock.hash);
  Block secondBlock=new Block("区块链2的hash：",genesisBlock.hash);
  System.out.println("区块2的hash："+secondBlock.hash);
  Block thirdBlock=new Block("区块链3的hash：",secondBlock.hash);
  System.out.println("区块3的hash："+thirdBlock.hash);*/
//第六步 2  add our blocks to the blockchain ArrayList:
  blockchain.add(new Block("区块1:","0"));
  blockchain.add(new Block("区块2:",blockchain.get(blockchain.size()-1).hash));
  blockchain.add(new Block("区块3:",blockchain.get(blockchain.size()-1).hash));
  String blockchainJson=new GsonBuider().setPrettyPrinting().create().toJson(blockchain);
  System.out.println(blockchainJson);
 }

// 第七步 :验证区块链的完整性
  public static Boolean isChainValid(){
   Block currentBlock;//当前区块
   Block previousBlock;//上一个区块
   //循环检查区块链
   for(int i=1;i<blockchain.size();i++){
    currentBlock=blockchain.get(i);
    previousBlock=blockchain.get(i-1);
    //比较登记注册的hash和计算得到的hash
    if (!currentBlock.hash.equals(currentBlock.calculateHash())){
     System.out.println("当前hash不相同");
      return false;
    }
    //比较前一个hash和注册的上一个hash
    if (!previousBlock.hash.equals(currentBlock.previousHash)){
     System.out.println("前一个区块hash不同");
     return false;
    }
   }
   return false;
   //链中区块发生任意的改变都会使该方法返回 false
 }
}

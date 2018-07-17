package cn.enderqiu.bcinvestrebuild.app.object;

import cn.enderqiu.bcinvestrebuild.app.object.response.MessageResponse;
import cn.enderqiu.bcinvestrebuild.app.object.serializer.ObjectSerializer;
import cn.ssyram.blockchain.innerlogic.Dispatcher;
import cn.ssyram.blockchain.innerlogic.dto.CollectDTO;
import cn.ssyram.blockchain.innerlogic.dto.LinkDTO;
import cn.ssyram.blockchain.innerlogic.entity.Block;
import cn.ssyram.blockchain.innerlogic.entity.BlockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.jvm.hotspot.opto.Block_List;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

@Service
public class ObjectView {

    /**
     * 接受一个序列化对象，根据 type 判断将此字节流反序列化为何种对象
     * @param serializer
     * @return
     */
    public MessageResponse receiveObject(ObjectSerializer serializer) throws IOException, ClassNotFoundException {
        String type = serializer.getType();
        MultipartFile data = serializer.getData();
        byte[] bytes = data.getBytes();

        ByteArrayInputStream byteInt=new ByteArrayInputStream(bytes);
        ObjectInputStream objInt=new ObjectInputStream(byteInt);

        if (type.equals("Block")){
            Block block = (Block) objInt.readObject();
            LinkDTO linkDTO = new LinkDTO();
            linkDTO.setBlock(block);
            Dispatcher.link(linkDTO);
        }else if (type.equals("BlockData")){
            ArrayList<BlockData> blockData = (ArrayList<BlockData>) objInt.readObject();
            CollectDTO collectDTO = new CollectDTO();
            collectDTO.setBlockDataList(blockData);
            Dispatcher.collect(collectDTO);
        }
        return new MessageResponse();
    }
}

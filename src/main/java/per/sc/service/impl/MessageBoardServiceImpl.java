package per.sc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.sc.mapper.MessageBoardMapper;
import per.sc.pojo.MessageBoard;
import per.sc.service.MessageBoardServiceI;

import java.util.List;


/**
 *
 * @author Administrator
 * @date 2019/8/2
 */
@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardServiceI {

    @Autowired
    private MessageBoardMapper mbMapper;

    @Override
    public void sendMessageBoard(MessageBoard messageBoard) {
        mbMapper.sendMessageBoard(messageBoard);
    }

    /**
     * init留言
     * @return
     */
    @Override
    public List<MessageBoard> queryMessageBoard() {
        return mbMapper.queryMessageBoard();
    }
}

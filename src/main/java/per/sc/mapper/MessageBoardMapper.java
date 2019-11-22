package per.sc.mapper;

import per.sc.pojo.MessageBoard;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/11/18
 */
public interface MessageBoardMapper {

    /**
     * 发布留言
     * @param messageBoard
     */
    void sendMessageBoard(MessageBoard messageBoard);

    /**
     * init留言
     * @return
     */
    List<MessageBoard> queryMessageBoard();
}

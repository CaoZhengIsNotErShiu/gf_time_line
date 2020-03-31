/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : time_line

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-03-31 17:58:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `thematic_url` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `art_first_menu` varchar(2) DEFAULT NULL COMMENT '一级菜单',
  `art_sub_menu` varchar(2) DEFAULT NULL COMMENT '二级菜单',
  `data` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES ('1', '1', '', '笑话', '2', '7', '<p>记者来到北极采访一群企鹅，遇到一只企鹅问：这么冷的天，你们平时都做点什么呢？</p><p>第一只企鹅回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者又问第二只企鹅，第二只企鹅也回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者这时在企鹅群中看到一个无精打采的企鹅，激动的说道，你一定就是豆豆喽！</p><p>那只无精打采的企鹅却说，我不是豆豆，我是觉觉。</p><p>哈哈哈哈，笑死我了</p>', '2019-12-11 16:09:43', '2019-11-15 17:36:48');
INSERT INTO `article_info` VALUES ('2', '1', '', '郭麒麟开超跑上热搜 郭麒麟很郁闷被当成玛莎拉蒂', '2', '8', '<p>近日，郭麒麟开超跑登上热搜，2019年9月9日，著名相声演员郭德纲之子郭麒麟，驾跑车被网友偶遇，一向低调的郭麒麟这次尽然如此高调出行，话说郭麒麟平时勤俭节约，说相声，巡演，拍戏凭自己能力赚钱，没有像别的富二代一样啃老，但是谁敢否认人家不是富二代?因为他的老爸叫郭德纲。这次开跑车出行，终于有个富二代应该有的排面了。&nbsp;&nbsp;<br></p>', '2019-09-10 16:11:48', '2019-11-15 17:36:57');
INSERT INTO `article_info` VALUES ('3', '1', '', '郭麒麟开超跑上热搜 郭麒麟很郁闷被当成玛莎拉蒂', '2', '7', '<p>近日，郭麒麟开超跑登上热搜，2019年9月9日，著名相声演员郭德纲之子郭麒麟，驾跑车被网友偶遇，一向低调的郭麒麟这次尽然如此高调出行，话说郭麒麟平时勤俭节约，说相声，巡演，拍戏凭自己能力赚钱，没有像别的富二代一样啃老，但是谁敢否认人家不是富二代?因为他的老爸叫郭德纲。这次开跑车出行，终于有个富二代应该有的排面了。&nbsp;&nbsp;<br></p>', '2019-09-10 16:11:48', '2019-09-10 16:11:48');
INSERT INTO `article_info` VALUES ('4', '13', '', '郭麒麟开超跑上热搜 郭麒麟很郁闷被当成玛莎拉蒂', '2', '7', '<p>近日，郭麒麟开超跑登上热搜，2019年9月9日，著名相声演员郭德纲之子郭麒麟，驾跑车被网友偶遇，一向低调的郭麒麟这次尽然如此高调出行，话说郭麒麟平时勤俭节约，说相声，巡演，拍戏凭自己能力赚钱，没有像别的富二代一样啃老，但是谁敢否认人家不是富二代?因为他的老爸叫郭德纲。这次开跑车出行，终于有个富二代应该有的排面了。&nbsp;&nbsp;<br></p>', '2019-09-10 16:11:48', '2019-09-10 16:11:48');
INSERT INTO `article_info` VALUES ('5', '2', '', '郭麒麟开超跑上热搜 郭麒麟很郁闷被当成玛莎拉蒂', '2', '7', '<p>近日，郭麒麟开超跑登上热搜，2019年9月9日，著名相声演员郭德纲之子郭麒麟，驾跑车被网友偶遇，一向低调的郭麒麟这次尽然如此高调出行，话说郭麒麟平时勤俭节约，说相声，巡演，拍戏凭自己能力赚钱，没有像别的富二代一样啃老，但是谁敢否认人家不是富二代?因为他的老爸叫郭德纲。这次开跑车出行，终于有个富二代应该有的排面了。&nbsp;&nbsp;<br></p>', '2019-09-10 16:11:48', '2019-09-10 16:11:48');
INSERT INTO `article_info` VALUES ('6', '13', '', '郭麒麟开超跑上热搜 郭麒麟很郁闷被当成玛莎拉蒂', '2', '7', '<p>近日，郭麒麟开超跑登上热搜，2019年9月9日，著名相声演员郭德纲之子郭麒麟，驾跑车被网友偶遇，一向低调的郭麒麟这次尽然如此高调出行，话说郭麒麟平时勤俭节约，说相声，巡演，拍戏凭自己能力赚钱，没有像别的富二代一样啃老，但是谁敢否认人家不是富二代?因为他的老爸叫郭德纲。这次开跑车出行，终于有个富二代应该有的排面了。&nbsp;&nbsp;<br></p>', '2019-09-10 16:11:48', '2019-09-10 16:11:48');
INSERT INTO `article_info` VALUES ('7', '2', '', '笑话', '2', '7', '<p>记者来到北极采访一群企鹅，遇到一只企鹅问：这么冷的天，你们平时都做点什么呢？</p><p>第一只企鹅回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者又问第二只企鹅，第二只企鹅也回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者这时在企鹅群中看到一个无精打采的企鹅，激动的说道，你一定就是豆豆喽！</p><p>那只无精打采的企鹅却说，我不是豆豆，我是觉觉。</p><p>哈哈哈哈，笑死我了</p>', '2019-09-10 16:09:43', '2019-09-10 16:09:43');
INSERT INTO `article_info` VALUES ('8', '1', '', '笑话', '2', '9', '<p>记者来到北极采访一群企鹅，遇到一只企鹅问：这么冷的天，你们平时都做点什么呢？</p><p>第一只企鹅回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者又问第二只企鹅，第二只企鹅也回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者这时在企鹅群中看到一个无精打采的企鹅，激动的说道，你一定就是豆豆喽！</p><p>那只无精打采的企鹅却说，我不是豆豆，我是觉觉。</p><p>哈哈哈哈，笑死我了</p>', '2019-09-15 16:09:43', '2019-11-15 17:37:10');
INSERT INTO `article_info` VALUES ('9', '1', '', '笑话', '2', '7', '<p>记者来到北极采访一群企鹅，遇到一只企鹅问：这么冷的天，你们平时都做点什么呢？</p><p>第一只企鹅回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者又问第二只企鹅，第二只企鹅也回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者这时在企鹅群中看到一个无精打采的企鹅，激动的说道，你一定就是豆豆喽！</p><p>那只无精打采的企鹅却说，我不是豆豆，我是觉觉。</p><p>哈哈哈哈，笑死我了</p>', '2019-09-14 16:09:43', '2019-09-10 16:09:43');
INSERT INTO `article_info` VALUES ('10', '1', '', '笑话', '2', '7', '<p>记者来到北极采访一群企鹅，遇到一只企鹅问：这么冷的天，你们平时都做点什么呢？</p><p>第一只企鹅回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者又问第二只企鹅，第二只企鹅也回答：吃饭饭，睡觉觉，打豆豆；</p><p>记者这时在企鹅群中看到一个无精打采的企鹅，激动的说道，你一定就是豆豆喽！</p><p>那只无精打采的企鹅却说，我不是豆豆，我是觉觉。</p><p>哈哈哈哈，笑死我了</p>', '2019-09-16 16:09:43', '2019-09-10 16:09:43');
INSERT INTO `article_info` VALUES ('11', '1', '', '笑话', '2', '7', '<img src=\"http://10.233.1.241:8088/image/522a8756-4597-4169-8c23-20191211.jpg\">', '2019-12-11 16:09:43', '2019-11-13 18:01:28');
INSERT INTO `article_info` VALUES ('12', '2', null, 'test', '2', '7', '<p>tsate</p>', '2019-09-17 17:52:42', '2019-09-12 17:52:42');
INSERT INTO `article_info` VALUES ('13', '13', null, '洞察力是打破僵局的利器', '2', '7', '<p>If you want to break the ice</p><p>do it with insight,</p><p><br></p><p><br></p>', '2019-09-16 14:47:23', '2019-09-16 14:47:23');
INSERT INTO `article_info` VALUES ('14', '13', null, 'test01', '2', '7', '<p>test01</p><p>test01&nbsp;</p><p>test01test01test01test01</p><p>test01</p><p>test01test01v</p><p>test01&nbsp;</p>', '2019-09-19 16:13:06', '2019-09-19 16:13:06');
INSERT INTO `article_info` VALUES ('15', '13', null, 'test01', '2', '7', '<p>123456</p>', '2019-09-23 14:00:59', '2019-09-23 14:00:59');
INSERT INTO `article_info` VALUES ('16', '13', null, 'test02', '2', '7', '<p>123414100</p>', '2019-09-23 14:04:41', '2019-09-23 14:04:41');
INSERT INTO `article_info` VALUES ('17', '1', null, '测试Solr-更新1', '2', '7', '<p>测试mq通信</p>', '2019-09-23 14:18:43', '2019-11-21 17:59:52');
INSERT INTO `article_info` VALUES ('18', '1', null, 'test mq', '2', '7', '<p>&nbsp;测试mq通信</p>', '2019-09-23 14:27:19', '2019-09-23 14:27:19');
INSERT INTO `article_info` VALUES ('19', '1', null, '测试用例', '2', '7', '<p>测试用例03</p>', '2019-09-23 14:29:27', '2019-09-23 14:29:27');
INSERT INTO `article_info` VALUES ('20', '1', null, '测试用例', '2', '7', '<p>测试用例03</p>', '2019-09-23 14:30:35', '2019-09-23 14:30:35');
INSERT INTO `article_info` VALUES ('21', '1', null, '测试mq', '2', '7', '<p>1001</p>', '2019-09-23 14:44:18', '2019-09-23 14:44:18');
INSERT INTO `article_info` VALUES ('22', '1', null, '测试用例', '2', '7', '<p>mq1002</p>', '2019-09-23 14:44:32', '2019-09-23 14:44:32');
INSERT INTO `article_info` VALUES ('23', '1', null, 'windows solr启动', '2', '8', '<p>cd bin</p><p>solr.cmd start</p>', '2019-09-25 10:33:19', '2019-09-25 10:33:19');
INSERT INTO `article_info` VALUES ('24', '1', null, 'windows solr启动', '2', '8', '<p>cd bin</p><p>solr.cmd start</p>', '2019-09-25 10:33:24', '2019-09-25 10:33:24');
INSERT INTO `article_info` VALUES ('25', '1', null, 'textarea输入内容不是从头开始', '2', '8', '<p><img src=\"http://10.233.1.241:8088/image/19cbf48b-b7c1-4e4f-9150-adaf9e23370b.jpg\" style=\"max-width:100%;\"><br></p><p>这种情况是因为&lt;textarea&gt;&lt;/textarea&gt;标签中存在了空格，去掉空格即可</p>', '2019-10-12 14:59:21', '2019-10-12 14:59:21');
INSERT INTO `article_info` VALUES ('26', '1', null, '逃避虽可耻但有用', '2', '8', '<div label-module=\"para\">&nbsp;&nbsp;&nbsp;&nbsp;《逃避虽可耻但有用》是日本TBS电视台2016年制作播出的爱情喜剧，由<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E5%9C%9F%E4%BA%95%E8%A3%95%E6%B3%B0/664884\">土井裕泰</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%91%E5%AD%90%E6%96%87%E7%BA%AA/4847220\">金子文纪</a>、<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E7%9F%B3%E4%BA%95%E5%BA%B7%E6%99%B4/9902217\">石井康晴</a>等执导，<a target=\"_blank\" href=\"https://baike.baidu.com/item/%E9%87%8E%E6%9C%A8%E4%BA%9A%E7%BA%AA%E5%AD%90\">野木亚纪子</a>编剧，新垣结衣主演。于2016年10月11日首播。</div><p><br></p><div label-module=\"para\">&nbsp; &nbsp; &nbsp;该剧改编自海野津美创作的同名漫画，讲述了研究生毕业却找不到工作的森山实栗选择与上班族津崎“契约结婚”，以主妇作为自己职业，二人在共同生活中领悟爱情真谛的故事。<sup>&nbsp;[1]</sup><a name=\"ref_[1]_20578811\">&nbsp;</a></div><div label-module=\"para\"><a name=\"ref_[1]_20578811\"><br></a></div><div label-module=\"para\"><a name=\"ref_[1]_20578811\"><img src=\"http://10.233.1.241:8088/image/5ee5b514-4a96-48d7-87f2-91c4159044b5.jpg\" style=\"max-width:100%;\"><br></a></div><div label-module=\"para\"><a name=\"ref_[1]_20578811\"><img src=\"http://10.233.1.241:8088/image/3f1b2d05-0371-4556-9054-6ee4943b290b.jpg\" style=\"max-width:100%;\"><br></a></div><div label-module=\"para\"><a name=\"ref_[1]_20578811\"><br></a></div><div label-module=\"para\"><a name=\"ref_[1]_20578811\"><br></a></div>', '2019-10-14 14:55:43', '2019-10-14 14:55:43');
INSERT INTO `article_info` VALUES ('27', '1', null, '新垣结衣图片', '2', '8', '<p><img src=\"http://10.233.1.241:8088/image/522a8756-4597-4169-8c23-1e2f18b884bc.jpg\" style=\"max-width:100%;\"><img src=\"http://10.233.1.241:8088/image/d9190f8c-3a93-4f3b-a967-a3e2e3deedb4.jpg\" style=\"max-width: 100%;\"><br></p><p><img src=\"http://10.233.1.241:8088/image/4633c316-187b-42cf-89ab-cee25754d2eb.jpg\" style=\"max-width:100%;\"><img src=\"http://10.233.1.241:8088/image/47763402-9fd1-44fc-8bf9-0cf39737672b.jpg\" style=\"max-width: 100%;\"><br></p>', '2019-12-11 16:35:32', '2019-10-14 16:35:32');
INSERT INTO `article_info` VALUES ('28', '3', null, '哈哈哈哈', '3', '10', '<p><img src=\"http://10.233.1.241:8088/image/be63d766-f119-437d-947e-e673fd52c740.jpg\" style=\"max-width:100%;\"><br></p><p><img src=\"http://10.233.1.241:8088/image/b109fbf8-29c0-4961-a03c-123abc56bf62.jpg\" style=\"max-width:100%;\"><img src=\"http://10.233.1.241:8088/image/1150dd53-e525-439e-ab15-28148bb9b620.jpg\" style=\"max-width: 100%;\"><br></p>', '2019-10-17 17:51:10', '2019-11-15 16:52:43');
INSERT INTO `article_info` VALUES ('29', '3', null, 'test', '2', '8', '<p>test000000000000001</p>', '2019-10-18 10:40:42', '2019-10-18 10:40:42');
INSERT INTO `article_info` VALUES ('30', '1', null, '123', '2', '8', '<p>1231</p>', '2019-10-23 10:29:25', '2019-10-23 10:29:25');
INSERT INTO `article_info` VALUES ('31', '1', null, '123', '2', '7', '<p>123</p>', '2019-10-23 10:37:35', '2019-10-23 10:37:35');
INSERT INTO `article_info` VALUES ('32', '1', null, '中山陵的一天', '2', '7', '<p><img src=\"http://10.233.1.241:8088/image/6e3eba43-a47e-43ec-9d4d-2486a236a18c.jpg\" style=\"max-width:100%;\"><br></p>', '2019-11-08 15:06:09', '2019-11-21 17:44:02');
INSERT INTO `article_info` VALUES ('33', '1', null, '中山陵的蓝天', '2', '7', '<p><img src=\"http://10.233.1.241:8088/image/6e3eba43-a47e-43ec-9d4d-2486a236a18c.jpg\" style=\"max-width:100%;\"><br></p>', '2019-11-13 16:30:10', '2019-11-21 17:45:48');
INSERT INTO `article_info` VALUES ('34', '1', null, 'sql语句查询一条数据的上一条数据和下一条数据', '3', '11', '<p>1.查询上一条数据<br><br></p><pre><h3><code>select * from tbContent where id=(select max(id) from tbContent where id&lt;searchId)</code></h3></pre><p><br></p><p>2.查询下一条数据<br><br></p><pre><h4></h4><h3><code>select * from tbContent where id=(select min(id) from tbContent where id&gt;searchId)</code></h3></pre><p><br></p><p>3.查询上一条和下一条数据<br></p><pre><code>select * from tbContent where <br>id in((select max(id) from tbContent where id&lt; searchId), <br>(select min(id) from tbContent where id&gt; searchId))</code></pre><p><br></p>', '2019-11-20 17:43:12', '2019-11-20 17:44:04');
INSERT INTO `article_info` VALUES ('35', '1', null, '测试Solr-更5', '2', '7', '<p>可以了吧</p><p>还是不行吗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>', '2019-11-21 17:48:05', '2019-11-22 10:32:00');
INSERT INTO `article_info` VALUES ('36', '1', null, 'Test ', '2', '7', '<p>tet</p>', '2019-11-22 16:27:57', '2019-11-22 16:27:57');
INSERT INTO `article_info` VALUES ('37', '1', null, 'Test ', '2', '7', '<p>tet</p>', '2019-11-22 16:29:16', '2019-11-22 16:29:16');
INSERT INTO `article_info` VALUES ('38', '1', null, '123', '2', '7', '<p>123</p>', '2019-11-22 16:30:52', '2019-11-22 16:30:52');
INSERT INTO `article_info` VALUES ('39', '1', null, '123', '2', '7', '<p>123</p>', '2019-11-22 16:31:34', '2019-11-22 16:31:34');
INSERT INTO `article_info` VALUES ('40', '1', null, '123', '2', '7', '<p>123</p>', '2019-11-22 16:32:03', '2019-11-22 16:32:03');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论id',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论人userId',
  `user_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评论人名称',
  `article_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '评论的文章id',
  `article_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '评论的文章标题',
  `parent_comment_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '父评论id',
  `parent_comment_user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '父评论的用户id',
  `reply_comment_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '被回复的评论id',
  `reply_comment_user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '被回复的评论用户id',
  `comment_level` tinyint(4) NOT NULL DEFAULT '1' COMMENT '评论等级[ 1 一级评论 默认 ，2 二级评论]',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评论的内容',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 (1 有效，0 逻辑删除)',
  `praise_num` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `top_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '置顶状态[ 1 置顶，0 不置顶 默认 ]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `idx_article_id` (`article_id`) USING BTREE,
  KEY `idx_user_id` (`user_id`) USING BTREE,
  KEY `idx_create_time` (`create_time`),
  KEY `idx_parent_comment_id` (`parent_comment_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='文章评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for follow_info
-- ----------------------------
DROP TABLE IF EXISTS `follow_info`;
CREATE TABLE `follow_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `follower_id` int(11) DEFAULT NULL,
  `by_follower_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of follow_info
-- ----------------------------
INSERT INTO `follow_info` VALUES ('3', '3', '1', '2019-09-20 13:42:18', '2019-09-20 13:42:18');
INSERT INTO `follow_info` VALUES ('4', '3', '2', '2019-09-20 14:06:27', '2019-09-20 14:06:31');

-- ----------------------------
-- Table structure for like_num_info
-- ----------------------------
DROP TABLE IF EXISTS `like_num_info`;
CREATE TABLE `like_num_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like_num_info
-- ----------------------------
INSERT INTO `like_num_info` VALUES ('2', '1', '1', '2019-09-11 10:04:39');
INSERT INTO `like_num_info` VALUES ('33', '1', '13', '2019-09-19 16:12:45');
INSERT INTO `like_num_info` VALUES ('34', '1', '14', '2019-09-19 16:24:46');
INSERT INTO `like_num_info` VALUES ('35', '1', '12', '2019-09-19 16:24:49');
INSERT INTO `like_num_info` VALUES ('36', '1', '2', '2019-09-19 16:24:49');
INSERT INTO `like_num_info` VALUES ('37', '1', '3', '2019-09-19 16:24:51');
INSERT INTO `like_num_info` VALUES ('38', '1', '11', '2019-09-19 16:24:55');
INSERT INTO `like_num_info` VALUES ('39', '1', '10', '2019-09-19 16:24:55');
INSERT INTO `like_num_info` VALUES ('40', '1', '4', '2019-09-19 16:25:04');
INSERT INTO `like_num_info` VALUES ('41', '1', '6', '2019-09-19 16:25:07');
INSERT INTO `like_num_info` VALUES ('42', '1', '5', '2019-09-19 16:25:09');
INSERT INTO `like_num_info` VALUES ('43', '1', '7', '2019-09-19 16:25:10');
INSERT INTO `like_num_info` VALUES ('44', '1', '8', '2019-09-19 16:25:11');
INSERT INTO `like_num_info` VALUES ('45', '13', '14', '2019-09-20 13:35:45');
INSERT INTO `like_num_info` VALUES ('46', '13', '8', '2019-09-20 13:38:49');
INSERT INTO `like_num_info` VALUES ('47', '3', '7', '2019-09-23 14:36:34');
INSERT INTO `like_num_info` VALUES ('48', '3', '1', '2019-09-23 15:45:21');
INSERT INTO `like_num_info` VALUES ('49', '3', '2', '2019-09-23 15:45:24');
INSERT INTO `like_num_info` VALUES ('51', '1', '26', '2019-10-14 16:43:33');
INSERT INTO `like_num_info` VALUES ('52', '1', '27', '2019-10-14 16:43:35');
INSERT INTO `like_num_info` VALUES ('54', '3', '27', '2019-10-17 17:49:29');
INSERT INTO `like_num_info` VALUES ('55', '3', '26', '2019-10-17 17:49:31');
INSERT INTO `like_num_info` VALUES ('56', '1', '31', '2019-11-04 12:01:03');
INSERT INTO `like_num_info` VALUES ('58', '3', '33', '2019-11-15 14:58:15');
INSERT INTO `like_num_info` VALUES ('60', '3', '32', '2019-11-15 15:07:07');
INSERT INTO `like_num_info` VALUES ('61', '3', '31', '2019-11-15 15:07:09');
INSERT INTO `like_num_info` VALUES ('65', '1', '33', '2019-11-21 15:44:34');
INSERT INTO `like_num_info` VALUES ('68', '1', '34', '2019-11-21 17:28:34');

-- ----------------------------
-- Table structure for menu_info
-- ----------------------------
DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `menu_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '自增长主键id',
  `menu_text` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `menu_url` varchar(32) DEFAULT NULL COMMENT '资源访问路径',
  `menu_parent_id` varchar(32) DEFAULT NULL COMMENT '上级目录id',
  `menu_level` varchar(32) DEFAULT NULL COMMENT '菜单等级',
  `menu_create_time` datetime DEFAULT NULL COMMENT '该条记录创建时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu_info
-- ----------------------------
INSERT INTO `menu_info` VALUES ('1', '首页', 'index', '0', '0', '2019-10-18 11:25:02');
INSERT INTO `menu_info` VALUES ('2', '生活笔记', 'note', '0', '0', '2019-10-18 11:25:36');
INSERT INTO `menu_info` VALUES ('3', '技术杂谈', 'technology', '0', '0', '2019-10-18 11:26:29');
INSERT INTO `menu_info` VALUES ('4', '给我留言', 'message', '0', '0', '2019-10-18 11:27:19');
INSERT INTO `menu_info` VALUES ('5', '技术栈', 'stack', '0', '0', '2019-10-18 11:27:25');
INSERT INTO `menu_info` VALUES ('6', '写文章', 'article', '0', '0', '2019-10-18 11:28:32');
INSERT INTO `menu_info` VALUES ('7', '个人随笔', 'jotting', '2', '1', '2019-10-18 11:35:06');
INSERT INTO `menu_info` VALUES ('8', '个人日记', 'jour', '2', '1', '2019-10-18 11:37:30');
INSERT INTO `menu_info` VALUES ('9', '个人展示', 'show', '2', '1', '2019-10-18 11:37:33');
INSERT INTO `menu_info` VALUES ('10', '前端', 'front', '3', '1', '2019-10-18 11:37:37');
INSERT INTO `menu_info` VALUES ('11', '后端', 'after', '3', '1', '2019-10-18 11:37:39');
INSERT INTO `menu_info` VALUES ('12', 'linux', 'liunx', '3', '1', '2019-10-18 11:37:42');
INSERT INTO `menu_info` VALUES ('13', 'Other', 'other', '3', '1', '2019-10-18 11:37:45');

-- ----------------------------
-- Table structure for message_board_info
-- ----------------------------
DROP TABLE IF EXISTS `message_board_info`;
CREATE TABLE `message_board_info` (
  `mb_id` int(11) NOT NULL AUTO_INCREMENT,
  `mb_text` varchar(255) DEFAULT NULL,
  `mb_author` varchar(255) DEFAULT NULL,
  `mb_email` varchar(255) DEFAULT NULL,
  `mb_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`mb_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message_board_info
-- ----------------------------
INSERT INTO `message_board_info` VALUES ('1', '第一次留言', '123456', '1046802917@qq.com', '2019-11-18 15:29:11');
INSERT INTO `message_board_info` VALUES ('2', '213123', '123', '1046802917@qq.com', '2019-11-18 16:35:31');
INSERT INTO `message_board_info` VALUES ('3', '123', '123', '1046802917@qq.com', '2019-11-18 16:36:26');
INSERT INTO `message_board_info` VALUES ('4', '123', '123', '1046802917@qq.com', '2019-11-18 16:37:37');
INSERT INTO `message_board_info` VALUES ('5', '123123', '123123', '1046802917@qq.com', '2019-11-18 16:38:29');
INSERT INTO `message_board_info` VALUES ('6', '123123', '123123', '1046802917@qq.com', '2019-11-18 16:38:32');
INSERT INTO `message_board_info` VALUES ('7', '123123', '123123', '1046802917@qq.com', '2019-11-18 16:38:33');
INSERT INTO `message_board_info` VALUES ('8', '456789', '123', '1046802917@qq.com', '2019-11-19 09:38:11');
INSERT INTO `message_board_info` VALUES ('9', '123456', '123', '1046802917@qq.com', '2019-11-19 09:42:20');
INSERT INTO `message_board_info` VALUES ('10', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:31');
INSERT INTO `message_board_info` VALUES ('11', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:33');
INSERT INTO `message_board_info` VALUES ('12', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:34');
INSERT INTO `message_board_info` VALUES ('13', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:35');
INSERT INTO `message_board_info` VALUES ('14', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:37');
INSERT INTO `message_board_info` VALUES ('15', 'userlist.stream().collect(Collectors.toMap(User::getAge, Function.identity()));', '231321', '1046802917@qq.com', '2019-11-19 12:01:37');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'admin:query', '管理员查询');
INSERT INTO `permission` VALUES ('2', 'admin:add', '管理员增加');
INSERT INTO `permission` VALUES ('3', 'admin:update', '管理员修改');
INSERT INTO `permission` VALUES ('4', 'admin:del', '管理员删除');
INSERT INTO `permission` VALUES ('5', 'ord:query', '普通员工查询');

-- ----------------------------
-- Table structure for release_info
-- ----------------------------
DROP TABLE IF EXISTS `release_info`;
CREATE TABLE `release_info` (
  `release_id` int(11) NOT NULL AUTO_INCREMENT,
  `release_context` varchar(255) DEFAULT NULL,
  `release_create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`release_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of release_info
-- ----------------------------
INSERT INTO `release_info` VALUES ('1', '张三1', '2019-11-29 11:56:31');
INSERT INTO `release_info` VALUES ('2', '张三2', '2018-11-29 11:56:38');
INSERT INTO `release_info` VALUES ('3', '张三3', '2017-11-29 11:56:47');
INSERT INTO `release_info` VALUES ('4', '张三4', '2016-11-29 11:56:47');
INSERT INTO `release_info` VALUES ('5', '张三5', '2015-11-29 11:56:48');
INSERT INTO `release_info` VALUES ('6', 'crush', '2019-11-28 12:09:31');
INSERT INTO `release_info` VALUES ('7', '项目灵感来源，一次坐车途中，想有一个用来记录一些特殊事件，特殊时间的网站，后来越做越多，越做越杂，就干脆在原有初衷上，实现更多功能，用来记录平时学习、生活的一些内容，一个真正意义上的博客网站', '2019-11-29 13:50:00');
INSERT INTO `release_info` VALUES ('8', '增加版本迭代提示功能', '2019-11-29 15:03:15');
INSERT INTO `release_info` VALUES ('9', '增加天气预报功能', '2019-11-29 15:03:56');
INSERT INTO `release_info` VALUES ('10', '修改版本迭代提交成功后，文本框消息不清除BUG', '2019-11-29 15:04:45');
INSERT INTO `release_info` VALUES ('11', '123', '2019-11-29 15:06:38');
INSERT INTO `release_info` VALUES ('12', '新增天气功能，用于显示南京、苏州、灌云、宿迁、新沂等地七天天气！', '2019-11-29 16:38:01');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(32) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', 'admin');
INSERT INTO `role` VALUES ('2', '普通人员', 'ordinary ');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `permission_id` int(32) NOT NULL,
  `role_id` int(32) NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1');
INSERT INTO `role_permission` VALUES ('1', '2');
INSERT INTO `role_permission` VALUES ('2', '1');
INSERT INTO `role_permission` VALUES ('3', '1');
INSERT INTO `role_permission` VALUES ('4', '1');

-- ----------------------------
-- Table structure for time_line_info
-- ----------------------------
DROP TABLE IF EXISTS `time_line_info`;
CREATE TABLE `time_line_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `image_url` mediumblob,
  `color` varchar(255) DEFAULT NULL,
  `picture` varchar(255) NOT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of time_line_info
-- ----------------------------
INSERT INTO `time_line_info` VALUES ('1', null, '2019-07-12', '<p style=\"font-size:30px;color:red\">&nbsp;&nbsp;百无一用是深情，不屑一顾是相思</p><p align=\"right\" style=\"font-size:30px;color:orange\">—评论陈奕迅《一丝不挂》</p>', null, 'cd-timeline-img cd-movie', '/images/cd-icon-location.svg', '2019-07-12 11:36:07', '2019-07-12 11:36:07');
INSERT INTO `time_line_info` VALUES ('2', null, '可以发送自己写的表情', '<br>\n', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F32336330373837382D663035662D343865312D383436322D6566343364613430383663362E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-12 12:01:10', '2019-07-12 12:01:10');
INSERT INTO `time_line_info` VALUES ('3', null, '人来人往', '\n我也开心饮过酒', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F62663734303963362D363631352D343338652D396465372D3235313737353537306265632E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-12 16:23:47', '2019-07-12 16:23:47');
INSERT INTO `time_line_info` VALUES ('4', null, '周杰伦超话第一', '话题tag从”周杰伦需要做数据吗“”周杰伦的粉丝去哪儿了“，到“周杰伦粉丝被迫营业“，再到”周杰伦超话第一“，周杰伦在粉丝的助力下，在7月21日凌晨1点冲上微博超话榜第一，并持续到现在。\n            ', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F38653236383335652D353532642D343166612D383061302D6431343561666261653332322E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-22 17:40:36', '2019-07-22 17:40:36');
INSERT INTO `time_line_info` VALUES ('5', null, '于谦回应微博围观 转发了不雅观的内容', '\n&nbsp;&nbsp;　7月21日，在《脱口秀大会》中，于谦回应了微博围观事件，称没有被盗号，只是看了有艾特自己的内容，结果被系统自动转发了。\n            ', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F66306566393031322D626633372D343439612D626131352D6561383966643836386162312E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-23 10:32:26', '2019-07-23 10:32:26');
INSERT INTO `time_line_info` VALUES ('6', null, '甜亮被移出群聊', '\n            现在骗子都组队吗？\n你瘾不小啊！\n', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F61333733663331372D326661322D343665392D393138632D3038633930383939353163302E6A706740687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F35356563353134332D343065342D346162362D613563352D3335343466393737353862352E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-23 10:43:17', '2019-07-23 10:43:17');
INSERT INTO `time_line_info` VALUES ('7', null, '离思五首·其四', '\n\n<p align=\"center\">作者：元稹</p>\n\n曾经沧海难为水，除却巫山不是云。\n取次花丛懒回顾，半缘修道半缘君。\n            ', null, 'cd-timeline-img cd-movie', '/images/cd-icon-location.svg', '2019-07-23 11:40:15', '2019-07-23 11:40:15');
INSERT INTO `time_line_info` VALUES ('8', null, '2019-07-23', 'null', null, 'cd-timeline-img cd-movie', '/images/cd-icon-location.svg', '2019-07-23 14:34:57', '2019-07-23 14:34:57');
INSERT INTO `time_line_info` VALUES ('9', null, '404', '\n这是一个bug解释界面', 0x687474703A2F2F31302E3233332E312E3234303A383038382F696D6167652F61366339623531342D646366352D346166322D393435662D3261383136656630623138332E6A7067, 'cd-timeline-img cd-picture', '/images/cd-icon-picture.svg', '2019-07-23 14:37:51', '2019-07-23 14:37:51');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `customer_id` varchar(32) NOT NULL COMMENT '用户Id',
  `parent_comment_id` varchar(32) NOT NULL DEFAULT '0' COMMENT '父评论Id',
  `content_id` varchar(32) NOT NULL COMMENT '评论对象的Id',
  `type` int(11) DEFAULT '1' COMMENT '评论对象的类型',
  `content` varchar(140) DEFAULT NULL COMMENT '评论内容',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `state` int(11) DEFAULT '0' COMMENT '评论的状态 0显示或者1不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', '0', '13', '1', '斯隆女士', '2019-09-17 10:30:37', '0');
INSERT INTO `t_comment` VALUES ('2', '1', '0', '13', '1', '洞察力是打破僵局的利器', '2019-09-17 11:29:18', '0');
INSERT INTO `t_comment` VALUES ('3', '1', '1', '13', '1', '很棒的电影呢', '2019-09-17 11:29:29', '0');
INSERT INTO `t_comment` VALUES ('4', '1', '2', '13', '1', '嗯', '2019-09-17 11:29:47', '0');
INSERT INTO `t_comment` VALUES ('5', '1', '3', '1', '1', '嗯嗯', '2019-09-17 11:30:23', '0');
INSERT INTO `t_comment` VALUES ('6', '1', '0', '11', '1', '真是有够好笑呢', '2019-09-17 14:30:12', '0');
INSERT INTO `t_comment` VALUES ('7', '1', '0', '12', '1', 'test', '2019-09-17 14:33:00', '0');
INSERT INTO `t_comment` VALUES ('8', '1', '0', '10', '1', '还真是好笑呢', '2019-09-17 15:05:51', '0');
INSERT INTO `t_comment` VALUES ('9', '1', '8', '10', '1', '是的呢', '2019-09-17 15:06:01', '0');
INSERT INTO `t_comment` VALUES ('10', '1', '9', '8', '1', '是的呢01', '2019-09-17 15:06:29', '0');
INSERT INTO `t_comment` VALUES ('11', '1', '0', '9', '1', '123', '2019-09-17 15:14:32', '0');
INSERT INTO `t_comment` VALUES ('12', '1', '11', '9', '1', '456', '2019-09-17 15:14:40', '0');
INSERT INTO `t_comment` VALUES ('13', '1', '12', '11', '1', '789', '2019-09-17 15:14:51', '0');
INSERT INTO `t_comment` VALUES ('14', '1', '12', '11', '1', '456789', '2019-09-17 15:15:04', '0');
INSERT INTO `t_comment` VALUES ('15', '1', '0', '8', '1', '还真是好笑呢', '2019-09-17 15:23:25', '0');
INSERT INTO `t_comment` VALUES ('16', '1', '15', '8', '1', '123', '2019-09-17 15:23:32', '0');
INSERT INTO `t_comment` VALUES ('17', '1', '8', '10', '1', '12312312', '2019-09-17 15:25:16', '0');
INSERT INTO `t_comment` VALUES ('18', '1', '7', '12', '1', '123123', '2019-09-17 15:26:15', '0');
INSERT INTO `t_comment` VALUES ('19', '1', '18', '7', '1', '123123', '2019-09-17 15:26:31', '0');
INSERT INTO `t_comment` VALUES ('20', '1', '0', '7', '1', '123', '2019-09-17 15:59:44', '0');
INSERT INTO `t_comment` VALUES ('21', '1', '0', '7', '1', '456', '2019-09-17 15:59:51', '0');
INSERT INTO `t_comment` VALUES ('22', '1', '0', '2', '1', '123', '2019-09-17 16:11:30', '0');
INSERT INTO `t_comment` VALUES ('23', '2', '22', '2', '1', '123123', '2019-09-17 16:11:34', '0');
INSERT INTO `t_comment` VALUES ('24', '1', '23', '22', '1', '123123123123', '2019-09-17 16:11:42', '0');
INSERT INTO `t_comment` VALUES ('25', '1', '22', '2', '1', '', '2019-09-17 16:26:20', '0');
INSERT INTO `t_comment` VALUES ('26', '1', '22', '2', '1', '123212', '2019-09-17 16:26:24', '0');
INSERT INTO `t_comment` VALUES ('27', '1', '22', '2', '1', '1123123', '2019-09-17 16:26:58', '0');
INSERT INTO `t_comment` VALUES ('28', '1', '27', '2', '1', '123123123123', '2019-09-17 16:27:09', '0');
INSERT INTO `t_comment` VALUES ('29', '1', '27', '2', '1', '擦擦擦', '2019-09-17 16:27:18', '0');
INSERT INTO `t_comment` VALUES ('30', '1', '1', '13', '1', '123123123', '2019-09-17 16:28:50', '0');
INSERT INTO `t_comment` VALUES ('31', '1', '19', '18', '1', '擦擦擦', '2019-09-17 16:30:03', '0');
INSERT INTO `t_comment` VALUES ('32', '1', '7', '12', '1', '啛啛喳喳', '2019-09-17 16:30:09', '0');
INSERT INTO `t_comment` VALUES ('33', '1', '19', '18', '1', '', '2019-09-17 16:30:18', '0');
INSERT INTO `t_comment` VALUES ('34', '1', '7', '12', '1', '萨达', '2019-09-17 16:30:52', '0');
INSERT INTO `t_comment` VALUES ('35', '1', '2', '13', '1', '123123', '2019-09-17 16:33:03', '0');
INSERT INTO `t_comment` VALUES ('36', '1', '2', '13', '1', '123123阿斯顿发', '2019-09-17 16:33:09', '0');
INSERT INTO `t_comment` VALUES ('37', '1', '7', '12', '1', '123123123哎哎哎', '2019-09-17 16:33:37', '0');
INSERT INTO `t_comment` VALUES ('38', '1', '1', '13', '1', '啊的说法', '2019-09-17 16:33:50', '0');
INSERT INTO `t_comment` VALUES ('39', '1', '2', '13', '1', '123123按时发大水', '2019-09-17 16:33:56', '0');
INSERT INTO `t_comment` VALUES ('40', '1', '7', '12', '1', '123123213哎哎哎', '2019-09-17 16:34:13', '0');
INSERT INTO `t_comment` VALUES ('41', '1', '22', '2', '1', '12312312哎哎哎', '2019-09-17 16:34:53', '0');
INSERT INTO `t_comment` VALUES ('42', '1', '41', '2', '1', '12312312', '2019-09-17 16:35:00', '0');
INSERT INTO `t_comment` VALUES ('43', '1', '6', '11', '1', '1231231哎哎哎', '2019-09-17 16:35:35', '0');
INSERT INTO `t_comment` VALUES ('44', '1', '6', '11', '1', '哎哎哎', '2019-09-17 16:35:40', '0');
INSERT INTO `t_comment` VALUES ('45', '1', '44', '11', '1', '123123啊啊啊', '2019-09-17 16:35:48', '0');
INSERT INTO `t_comment` VALUES ('46', '1', '16', '15', '1', '123123啊', '2019-09-17 16:37:28', '0');
INSERT INTO `t_comment` VALUES ('47', '1', '15', '8', '1', '12312 啊', '2019-09-17 16:37:33', '0');
INSERT INTO `t_comment` VALUES ('48', '1', '33', '19', '1', '12312312啊啊啊', '2019-09-17 16:47:14', '0');
INSERT INTO `t_comment` VALUES ('49', '13', '0', '14', '1', '写的什么玩意', '2019-09-20 13:35:59', '0');
INSERT INTO `t_comment` VALUES ('50', '3', '0', '27', '1', '老婆真好看！', '2019-10-15 14:52:52', '0');
INSERT INTO `t_comment` VALUES ('51', '3', '0', '26', '1', '这个挺好看的呢，治愈', '2019-10-15 15:03:03', '0');
INSERT INTO `t_comment` VALUES ('52', '3', '0', '26', '1', '猪突猛进', '2019-10-15 15:05:42', '0');
INSERT INTO `t_comment` VALUES ('53', '3', '0', '26', '1', '嘴平伊之助 ', '2019-10-15 15:06:32', '0');
INSERT INTO `t_comment` VALUES ('54', '3', '0', '27', '1', '猪突猛进', '2019-10-15 15:09:53', '0');
INSERT INTO `t_comment` VALUES ('55', '3', '0', '27', '1', '可爱', '2019-10-15 15:09:58', '0');
INSERT INTO `t_comment` VALUES ('56', '3', '0', '25', '1', '原来如此', '2019-10-15 15:18:32', '0');
INSERT INTO `t_comment` VALUES ('57', '3', '0', '25', '1', '原来如此', '2019-10-15 15:19:02', '0');
INSERT INTO `t_comment` VALUES ('58', '3', '0', '24', '1', '明白了', '2019-10-15 15:19:32', '0');
INSERT INTO `t_comment` VALUES ('59', '3', '0', '27', '1', '爱了', '2019-10-15 15:21:19', '0');
INSERT INTO `t_comment` VALUES ('60', '3', '0', '20', '1', '测试评论', '2019-10-15 15:21:32', '0');
INSERT INTO `t_comment` VALUES ('61', '3', '0', '22', '1', '写的不错\n', '2019-10-15 15:30:03', '0');
INSERT INTO `t_comment` VALUES ('62', '3', '0', '4', '1', '有点意思', '2019-10-15 15:31:36', '0');
INSERT INTO `t_comment` VALUES ('63', '3', '0', '4', '1', '有点意思', '2019-10-15 15:31:43', '0');
INSERT INTO `t_comment` VALUES ('64', '3', '0', '4', '1', '有点意思', '2019-10-15 15:32:54', '0');
INSERT INTO `t_comment` VALUES ('65', '3', '53', '26', '1', '哈哈哈', '2019-10-17 15:39:29', '0');
INSERT INTO `t_comment` VALUES ('66', '1', '59', '27', '1', '？？？', '2019-10-17 15:40:34', '0');
INSERT INTO `t_comment` VALUES ('67', '1', '55', '27', '1', '哈哈哈哈', '2019-10-17 15:44:57', '0');
INSERT INTO `t_comment` VALUES ('68', '3', '50', '27', '1', '是你老婆嘛？', '2019-10-17 15:47:21', '0');
INSERT INTO `t_comment` VALUES ('69', '3', '66', '27', '1', '在说什么哦', '2019-10-17 16:47:26', '0');
INSERT INTO `t_comment` VALUES ('70', '3', '0', '19', '1', '213123', '2019-10-17 17:33:34', '0');
INSERT INTO `t_comment` VALUES ('71', '3', '0', '19', '1', '456789', '2019-10-17 17:33:43', '0');
INSERT INTO `t_comment` VALUES ('72', '1', '71', '19', '1', '123456', '2019-10-17 17:37:54', '0');
INSERT INTO `t_comment` VALUES ('73', '1', '70', '19', '1', '456789654654', '2019-10-17 17:38:09', '0');
INSERT INTO `t_comment` VALUES ('74', '3', '72', '19', '1', '哈哈哈，我乱发的呢', '2019-10-17 17:41:12', '0');
INSERT INTO `t_comment` VALUES ('75', '1', '0', '32', '1', '天气真好', '2019-11-08 15:06:27', '0');
INSERT INTO `t_comment` VALUES ('76', '1', '0', '2', '1', '？？？', '2019-11-13 13:51:38', '0');
INSERT INTO `t_comment` VALUES ('77', '1', '76', '2', '1', '123456', '2019-11-13 13:51:50', '0');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(64) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `signature` varchar(255) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `image` varchar(255) DEFAULT NULL COMMENT '图片',
  `role_id` int(32) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1244833296481181696', 'TL_20200331114600424', '1335c87e502e87cefb6efca3b2cc7a34', null, '15651367595', '/38421562074311_.pic.jpg', '1', '2020-03-31 11:46:00', '2020-03-31 11:46:00');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `uid` varchar(32) NOT NULL,
  `role_id` int(32) NOT NULL,
  PRIMARY KEY (`uid`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('123456', '2');
INSERT INTO `user_role` VALUES ('1244833296481181696', '1');

拥有一个 beginWord 和一个 endWord，分别表示图上的
 start node 和 end node。我们希望利用一些中间节点（单词）从 
 start node 到 end node，中间节点是 wordList 给定的单词。我们
 对这个单词接龙每个步骤的唯一条件是相邻单词只可以改变一个字母。



我们将问题抽象在一个无向无权图中，每个单词作为节点，
差距只有一个字母的两个单词之间连一条边。问题变成找到从起
点到终点的最短路径，如果存在的话。因此可以使用广度优先搜索方法。

算法中最重要的步骤是找出相邻的节点，也就是只差一个字母的两个
单词。为了快速的找到这些相邻节点，我们对给定的 wordList 做一
个预处理，将单词中的某个字母用 * 代替。



这个预处理帮我们构造了一个单词变换的通用状态。
例如：Dog ----> D*g <---- Dig，Dog 和 Dig 都指向了一个通
用状态 D*g。

这步预处理找出了单词表中所有单词改变某个字母后的通用状态，并帮
助我们更方便也更快的找到相邻节点。否则，对于每个单词我们需要遍
历整个字母表查看是否存在一个单词与它相差一个字母，这将花费很多
时间。预处理操作在广度优先搜索之前高效的建立了邻接表。

例如，在广搜时我们需要访问 Dug 的所有邻接点，我们可以先生成 
Dug 的所有通用状态：

Dug => *ug
Dug => D*g
Dug => Du*
第二个变换 D*g 可以同时映射到 Dog 或者 Dig，因为他们都有相
同的通用状态。拥有相同的通用状态意味着两个单词只相差一个字母，
他们的节点是相连的。

方法 1：广度优先搜索
想法

利用广度优先搜索搜索从 beginWord 到 endWord 的路径。

算法

对给定的 wordList 做预处理，找出所有的通用状态。
将通用状态记录在字典中，键是通用状态，值是所有具
有通用状态的单词。

将包含 beginWord 和 1 的元组放入队列中，
1 代表节点的层次。我们需要返回 endWord 的
层次也就是从 beginWord 出发的最短距离。

为了防止出现环，使用访问数组记录。

当队列中有元素的时候，取出第一个元素，记为 current_word。

找到 current_word 的所有通用状态，
并检查这些通用状态是否存在其它单词的映射，
这一步通过检查 all_combo_dict 来实现。

从 all_combo_dict 获得的所有单词，
都和 current_word 共有一个通用状态，
所以都和 current_word 相连，因此将他们加入到队列中。

对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其
中 level 是 current_word 的层次。

最终当你到达期望的单词，对应的层次就是最短变换序列的长度。

标准广度优先搜索的终止条件就是找到结束单词。
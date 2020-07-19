from selenium import webdriver  # 用来驱动浏览器的
import time
import MySQLdb


def search_product(key):
    # 寻找到输入文字的搜索框 并将要搜索的内容key输入进去
    driver.find_element_by_id('q').send_keys(key)
    # 点击搜索按钮
    driver.find_element_by_class_name('btn-search').click()
    # 浏览器窗口最大化
    driver.maximize_window()
    # 15秒扫码时间
    time.sleep(15)


def get_product():
    # 解析淘宝商品数据
    divs = driver.find_elements_by_xpath('//div[@class="items"]/div[@class="item J_MouserOnverReq  "]')
    # print(divs)
    for div in divs:
        # 商品的提取 分析网页根据xpath语法找到商品 获取商品名称、价格、付款人数
        name = div.find_element_by_xpath('.//div[@class="row row-2 title"]/a').text
        price = div.find_element_by_xpath('.//strong').text
        peopleNum = div.find_element_by_xpath('.//div[@class="deal-cnt"]').text
        print(name, price, peopleNum, sep="|")
        # 将数据插入数据库的sql语句
        sql = "INSERT INTO taobao(name , price, peopleNum) VALUES ('%s', '%s', '%s')" % (name, price, peopleNum)
        # 执行sql将商品插入到数据库中
        cursor.execute(sql)
        db.commit()
    db.close()


def main():
    # 调用根据keyword查询商品方法
    search_product(keyword)
    # 获取查询到的商品数据
    get_product()


if __name__ == '__main__':
    # 与数据库中的lexian建立连接
    db = MySQLdb.connect("localhost", "root", "Xy990919", "lexian", charset='utf8')
    cursor = db.cursor()
    # 输入要爬取的商品名称
    keyword = input("请输入要搜索的关键字：")
    # 使用谷歌浏览器
    driver = webdriver.Chrome(executable_path="C:\\Program Files (x86)\Google\Chrome\Application\chromedriver.exe")
    # 访问淘宝
    driver.get('https://www.taobao.com/')
    main()

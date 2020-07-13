from selenium import webdriver
import time
import MySQLdb


def search_product(key):
    driver.find_element_by_id('q').send_keys(key)
    driver.find_element_by_class_name('btn-search').click()
    driver.maximize_window()
    # 15秒扫码时间
    time.sleep(15)


def get_product():
    # 解析淘宝商品数据
    divs = driver.find_elements_by_xpath('//div[@class="items"]/div[@class="item J_MouserOnverReq  "]')
    # print(divs)
    for div in divs:
        # 商品的提取
        name = div.find_element_by_xpath('.//div[@class="row row-2 title"]/a').text
        price = div.find_element_by_xpath('.//strong').text
        peopleNum = div.find_element_by_xpath('.//div[@class="deal-cnt"]').text
        print(name, price, peopleNum, sep="|")
        cursor.execute("insert into taobao(name,price,peopleNum) VALUES(%s,%f,%s)"%(name, price, peopleNum))
    db.close()

def main():
    search_product(keyword)
    get_product()


if __name__ == '__main__':
    db = MySQLdb.connect("localhost", "root", "Xy990919", "lexian", charset='utf8')
    cursor = db.cursor()
    keyword = input("请输入要搜索的关键字：")
    driver = webdriver.Chrome(executable_path="C:\\Program Files (x86)\Google\Chrome\Application\chromedriver.exe")
    driver.get('https://www.taobao.com/')
    main()

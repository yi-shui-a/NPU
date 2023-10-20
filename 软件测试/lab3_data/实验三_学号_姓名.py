from selenium import webdriver
from selenium.webdriver import ActionChains
import time

driver = webdriver.Chrome()
url = 'https://nj.zu.anjuke.com/'
driver.get(url)

driver.maximize_window()

driver.find_element_by_partial_link_text('租房').click()
time.sleep(1)
above = driver.find_element_by_id('switch_apf_id_5')
ActionChains(driver).move_to_element(above).perform()
driver.find_element_by_partial_link_text('南京').click()
time.sleep(1)
driver.find_element_by_partial_link_text('地铁找房').click()
time.sleep(1)
driver.find_element_by_partial_link_text('2号线').click()
time.sleep(1)
driver.find_element_by_partial_link_text('马群').click()
time.sleep(1)
driver.find_element_by_id('from-price').send_keys("5000")
time.sleep(1)
driver.find_element_by_id('to-price').send_keys("8000")
time.sleep(1)
driver.find_element_by_id('pricerange_search').click()
time.sleep(1)

driver.find_element_by_partial_link_text('整租').click()
time.sleep(1)

above = driver.find_element_by_id('condhouseage_txt_id')
ActionChains(driver).move_to_element(above).perform()
driver.find_element_by_partial_link_text('普通住宅').click()
time.sleep(1)

driver.find_element_by_id('search-rent').send_keys('经天路')
driver.find_element_by_id('search-button').click()
time.sleep(1)

driver.find_element_by_class_name('lastTab').click()
time.sleep(1)

driver.find_element_by_class_name('icon-arrup').click()
time.sleep(1)

driver.find_element_by_class_name('icon-arrdown').click()
time.sleep(1)
driver.find_element_by_class_name('zu-itemmod').click()
time.sleep(1)


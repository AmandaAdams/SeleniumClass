java -jar selenium-server-standalone-2.44.0.jar -role node -hub http://localhost:4444/grid/register -maxSession 15 -browser browserName="chrome",version=ANY,platform=WINDOWS,maxInstances=5 -Dwebdriver.chrome.driver=chromedriver.exe -browser browserName="firefox",version=ANY,platform=WINDOWS,maxInstances=5 -browser browserName="internet explorer",version=ANY,platform=WINDOWS,maxInstances=1 -Dwebdriver.ie.driver=IEDriverServer.exe

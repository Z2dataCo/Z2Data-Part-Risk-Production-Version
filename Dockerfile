FROM microsoft/windowsservercore:ltsc2016
MAINTAINER Zulu Enterprise Container Images <azul-zulu-images@microsoft.com>

RUN setx PACKAGE zulu-15-azure-jdk_15.28.51-15.0.1-win_x64.msi && \
    setx PACKAGE_DIR zulu-15/15.0.1 && \
    setx /m JAVA_HOME "C:\Program Files\Zulu\zulu-15"


RUN powershell -Command [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12;(new-object System.Net.WebClient).DownloadFile('https://repos.azul.com/azure-only/zulu/packages/zulu-15/15.0.1/zulu-15-azure-jdk_15.28.51-15.0.1-win_x64.msi', 'C:\%PACKAGE%')
RUN msiexec /quiet /i C:\%PACKAGE% && \
    del C:\%PACKAGE%

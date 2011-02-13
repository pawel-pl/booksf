#! /usr/bin/env python

'''Selenium Library Test Runner

Usage: runtest.py [options] datasource

This script starts necessary helper programs (Selenium server) and executes
the given test case file/directory. After test cases have finished executing,
the helper programs are shut down. 

Options are passed to Robot Framework as they are given, for a complete list
of options, run 'pybot --help'.

The speed of the test execution can be slowed by defining a non-zero value for
variable delay, eg. '--variable DELAY:2'

For debugging purposes, the output of Selenium server is written in 
'selenium_log.txt' under the 'reports' directory.

Requires that Robot Framework, Selenium Library, Python 2.4 or newer and 
Java 1.5 or newer are installed.
'''

import os
import sys
import time
import tempfile
from subprocess import Popen, call, STDOUT

import SeleniumLibrary
from SeleniumLibrary import selenium

USED_PORT=4449
INSTPATH = os.path.split(os.path.abspath(SeleniumLibrary.__file__))[0]
TMPFILE = tempfile.TemporaryFile()
if not os.path.exists('reports'):
    os.mkdir('reports')
SELENIUM_LOG_FILE = open(os.path.join('reports', 'selenium_log.txt'), 'w')
DEFAULT_ARGS = [ 
'--outputdir', 'reports', 
'--log', 'robot_log.html',
'--report', 'robot_report.html', 
'--output', 'robot_output.xml',
'--reporttitle', 'Selenium_Web_Robot_Report',
'--logtitle', 'Selenium_Web_Robot_Log']

def start_apps():
    jarpath = os.path.join(INSTPATH, 'lib', 'selenium-server.jar')
    Popen(['java', '-jar', jarpath, '-port', str(USED_PORT)], stdout=SELENIUM_LOG_FILE, stderr=STDOUT)
    time.sleep(1)

def run_test(cmdline_args):
    shell = (os.sep == '\\')
    call(['pybot'] + DEFAULT_ARGS + cmdline_args, shell=shell)
    print 'Selenium log:', os.path.abspath(SELENIUM_LOG_FILE.name)

def stop_apps():
    selenium('localhost', USED_PORT, '', '').do_command('shutDownSeleniumServer', [])

if __name__ == '__main__':
    if len(sys.argv) < 2 or '--help' in sys.argv[1]:
        print __doc__
        sys.exit(1)
    start_apps()
    run_test(sys.argv[1:])
    stop_apps()
    SELENIUM_LOG_FILE.close()
    TMPFILE.close()


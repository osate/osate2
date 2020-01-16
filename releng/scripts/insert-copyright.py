#!/usr/bin/env python3
# coding: utf-8

# This script can be used to replace existing copyright headers with new text

# It assumes that the existing header occurs before the first non-comment line
# in a file (except for XML, where the xml declaration must be the first element)

# It replaces the first such comment with the new text, or inserts the text as 
# the new first comment. 
 
import glob
import os
from pathlib import Path


def first_non_empty_line(f):
    line = f.readline().strip()
    i = 1
    return skip_empty_lines(f, line, i)


def skip_empty_lines(f, line, i):
    while line == '':
        line = f.readline().strip()
        i += 1
    return line, i


def skip_xml_decl(f, line, i):
    while line.startswith('<?xml'):
        line = f.readline().strip()
        i += 1
    return line, i


def line_comments(f, mark, line, i):
    result = []
    x = 1
    y = i
    while line.startswith(mark):
        result.append(line[len(mark):].lstrip())
        line = f.readline().strip()
        y += 1
    return result, x, y


def block_comment(f, start, mid, end, line, first, i):
    result = []
    x = first
    y = i
    if line.startswith(start):
        line = line[len(start):].lstrip()
        while not line.endswith(end):
            if line.startswith(mid):
                line = line[len(mid):].lstrip()
            if len(line) > 0 and not line.startswith('$Id:'):
                result.append(line)
            line = f.readline().strip()
            y += 1
        line = line[:-len(end)].rstrip()
        if line.startswith(mid):
            line = line[len(mid):].lstrip()
        if len(line) > 0 and not line.startswith('$Id:'):
            result.append(line[:-len(end)].rstrip())
        y += 1
    return result, x, y


def filetype(path):
    ext = Path(path).suffix
    if ext in ['.java', '.xtend', '.xtext', '.mwe2', '.xsemantics']:
        return 'java'
    elif ext in ['.xml', '.html', '.md']:
        return 'xml'
    elif ext in ['.properties']:
        return 'properties'
    else:
        return ''
    
def first_comment(path):
    with open(path, errors='surrogateescape') as f:
        line, i = first_non_empty_line(f)
        if filetype(path) == 'java':
            clines, x, y = block_comment(f, '/*', '*', '*/', line, 1, i)
        elif filetype(path) == 'xml':
            first = 1
            line, j = skip_xml_decl(f, line, i)
            if j > i:
                first = j
                line, i = skip_empty_lines(f, line, j)
            clines, x, y = block_comment(f, '<!--', '', '-->', line, first, i)
        elif filetype(path) == 'properties':
            clines, x, y = line_comments(f, '#', line, i)
        else:
            return '', -1, -1
    return ' '.join(clines), x, y


def valid_file(path):
    ignore = ['/ba/', '/ge/',
              'de/itemis', 'emf/workspace/util', 'aadl2/presentation/ResourceLoadedListener',
              'aadl2/presentation/Aadl2ModelEditor', 'aadl2/presentation/Aadl2ActionBarContributor',
              'aadl2/domain', '/pom.xml', '/feature.xml', '/settings.xml', '/filter.xml',
              '/xtend-gen/', '/generated/', '/bin/', '/target/', 'help/api', 'html/ref', 'html/std', 'cpl1-v10', '/build.properties']
    for d in ignore:
        if d in path:
            return False
    return os.path.isfile(path)


header_file = 'copyright-header.txt'
def write_header(f, pre, start, post):
    if pre != '':
        f.write(pre + '\n')
    with open(header_file, 'r') as h:
        for l in h.readlines():
            f.write(start + l)
    if post != '':
        f.write(post + '\n')
    
def insert_header(start, end, path):
    with open(path, 'r+', errors='surrogateescape') as f:
        l = 1
        while l < start:
            l += 1
            f.readline()   # skip past early lines
        pos = f.tell() # remember insertion position
        while l < end:
            l += 1
            f.readline() # skip over existing comment
        f_remainder = f.read()    # cache the rest of f2
        f.seek(pos)
        if filetype(path) == 'java':
            write_header(f, '/**', ' * ', ' ' + '*' + '/')
        elif filetype(path) == 'xml':
            write_header(f, '<!--', '', '-->')
        elif filetype(path) == 'properties':
            write_header(f, '', '# ', '')
        f.truncate(f.tell())
        f.write(f_remainder)


def copyright(extension):
    prefix = '/home/lw/git/osate2_2019-12/osate2/'
    pathlist = glob.glob(prefix + '**/*.' + ext, recursive=True)
    allcomments = {''}
    for path in pathlist:
        if valid_file(path):
            comment, x, y = first_comment(path)
            print('{},{},{}'.format(str(x), str(y), path[len(prefix):]))
            insert_header(x, y, path)
        
extensions = ['java', 'xtend', 'xml', 'xtext', 'mwe2', 'html', 'md', 'properties', 'xsemantics']
for ext in extensions:
    copyright(ext)


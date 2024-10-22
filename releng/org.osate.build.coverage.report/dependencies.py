import subprocess

cmd = ['mvn', '-Dexec.executable=echo', 
        '-Dexec.args=\'${project.groupId}:${project.artifactId}:${project.version}:${project.packaging}\'',
       'exec:exec', '-Dtycho.mode=maven', '-q', '-f', '../..']
proc = subprocess.Popen(cmd, encoding='utf8', stdout=subprocess.PIPE, bufsize=1)

indent = '    '
indent2 = indent + indent
indent3 = indent2 + indent

tags = ['groupId', 'artifactId', 'version']

print(indent + '<dependencies>')

for line in proc.stdout:
    parts = line.strip().split(':')
    if len(parts) < 4:
        break
    
    packaging = parts[3]
    
    if packaging.endswith('plugin'):
        if packaging == 'eclipse-test-plugin':
            scope = 'test'
        else:
            scope = 'compile'
            
        print(indent2 + '<dependency>')
        
        for i in range(len(tags)):
            print(indent3 + '<{0}>{1}</{0}>'.format(tags[i], parts[i]))
        
        print(indent3 + '<{0}>{1}</{0}>'.format('scope', scope))
        print(indent2 + '</dependency>')
        
print(indent + '</dependencies>')    

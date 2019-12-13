import subprocess

cmd = ['mvn', '-Dexec.executable=echo', '-Dexec.args=\'${project.groupId}:${project.artifactId}:${project.version}:${project.packaging}\'',
       'exec:exec', '-Dtycho.mode=maven', '-q', '-f', '../..']
proc = subprocess.run(cmd, encoding='utf8', stdout=subprocess.PIPE)

indent = '    '
indent2 = indent + indent
indent3 = indent2 + indent

print(indent + '<dependencies>')

for line in proc.stdout.split('\n'):
    parts = line.split(':')
    if len(parts) < 4:
        break
    
    groupId = parts[0]
    artifactId = parts[1]
    version = parts[2]
    packaging = parts[3]
    
    if packaging.endswith('plugin'):
        if packaging == 'eclipse-test-plugin':
            scope = 'test'
        else:
            scope = 'compile'
        
        print(indent2 + '<dependency>')
        print(indent3 + '<groupId>' + groupId + '</groupId>')
        print(indent3 + '<artifactId>' + artifactId + '</artifactId>')
        print(indent3 + '<version>' + version + '</version>')
        print(indent3 + '<scope>' + scope + '</scope>')
        print(indent2 + '</dependency>')
        
print(indent + '</dependencies>')    

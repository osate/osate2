# Count component instances in a system instance
# parameters: 
#   argv[0]: String - script name
#   argv[1]: SystemInstance - root instance object

def countComponents(instance):
    count = 1
    for c in instance.getComponentInstances():
    	count += countComponents(c)
    return count
    
def main(systemInstance):
    cs = countComponents(systemInstance)
    print('result = {}'.format(cs))
    return cs

print('executing ' + argv[0])
main(argv[1])




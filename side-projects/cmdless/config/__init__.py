import os


def load_config():
    """Load Config"""
    mode = os.environ.get('MODE')
    try:
        if mode == 'PRODUCTION':
            from .productionconfig import ProductionConfig
            return ProductionConfig
        elif mode == 'TESTING':
            from .testconfig import TestingConfig
            return TestingConfig
        else:
            from .developmentconfig import DevelopmentConfig
            return DevelopmentConfig
    except ImportError as err:
        from .default import Config
        return Config
